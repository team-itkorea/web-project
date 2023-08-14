let programTheme = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

load("/api/program/")
console.log(programTheme)

function load(uri) {
	$.ajax({
		type: "GET",
		url: uri + programTheme,
		dataType: "json",
		success: (response) => {
			console.log(response)
			getProgram(response.data)
		},
		error: (error) => {
            console.log(error)
        }
	})
}

function getProgram(list) {
	const tbody = document.querySelector(".contents")
	tbody.innerHTML = ''
	list.forEach(program => {
		tbody.innerHTML += `
			<div class="content">
	            <div class="img-section">
					<img src="/static/upload/program/${program.fileName}" onclick="getDetail('${programTheme}', '${program.code}')" alt="Image">
				</div>
				<div class="txt-section">
					<h3 class="program-name">[${program.theme}] ${program.title}</h3>
				</div>
	        </div>
		`
	})
}

function getDetail(programTheme, code) {
	window.location.href = "/program/" + programTheme + "/detail?code=" + code;
}
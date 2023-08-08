let programTheme = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

load("/api/program/")

function load(uri) {
	$.ajax({
		type: "POST",
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
					<img src="/static/upload/program/${program.fileName}" onclick="getDetail('${program.theme}', '${program.code}')" alt="Image">
				</div>
				<div class="txt-section">
					<h3 class="program-name">[${program.theme}] ${program.title}</h3>
				</div>
	        </div>
		`
	})
}

function getDetail(theme, code) {
	window.location.href = "/program/" + theme + "/detail?code=" + code;
}
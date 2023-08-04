let programTheme = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

load("/program/")

function load(uri) {
	$.ajax({
		type: "GET",
		url: uri + programTheme,
		dataType: "json",
		success: (response) => {
			getProgram(response.data)
		},
		error: (error) => {
            console.log(error)
            alert("실패")
		}
	})
}

function getProgram(program) {
	const tbody = document.querySelector(".contents")
	tbody.innerHTML = ''
	program.forEach(db => {
		tbody.innerHTML += `
			<div class="content">
	            <div class="img-section">
					<img src="file:///C:/upload/program/${db.fileName}" alt="Image">
				</div>
				<div class="txt-section">
					<h3 class="program-name">${db.theme} ${db.title}</h3>
				</div>
	        </div>
		`
	})
}

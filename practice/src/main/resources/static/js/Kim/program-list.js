let programTheme = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

load("/api/program/")

function load(uri) {
	$.ajax({
		type: "POST",
		url: uri + programTheme,
		dataType: "json",
		success: function(response) {
			console.log(response)
			getProgram(response.data)
		},
		error: function (error) {
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
					<img src="/static/upload/program/${program.fileName}" alt="Image">
				</div>
				<div class="txt-section">
					<h3 class="program-name">[${program.theme}] ${program.title}</h3>
				</div>
	        </div>
		`
	})
}

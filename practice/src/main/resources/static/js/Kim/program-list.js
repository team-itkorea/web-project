let programTheme = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

load("/program/")

function load(uri) {
	$.ajax({
		async: false,
		type: "GET",
		url: uri + programTheme,
		dataType: "json",
		success: (response) => {
			getProgram(response.data)
		},
		error: (error) => {
			console.log(error)
		}
	})
}

function getProgram(program) {
	const tbody = document.querySelector("tbody")
	tbody.innerHTML = ""
	program.forEach(notice => {
		tbody.innerHTML += `
			<tr class="notice-row">
	            <td>${notice.noticeCode}</td>
	            <td>${notice.noticeTitle}</td>
	            <td>${notice.userId}</td>
	            <td>${notice.createDate}</td>
	            <td>${notice.noticeCount}</td>
	        </tr>
		`
	})
}

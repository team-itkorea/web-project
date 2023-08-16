let programTheme = location.pathname.substring(location.pathname.lastIndexOf("-") + 1)

console.log(programTheme)

load("/admin/api/program/")

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
	const kind = document.querySelector(".header-theme")
	if(`${programTheme}` === 'l') { kind.textContent = "일상 탐험"}
	else { kind.textContent = "웰니스 클럽" }
	const tbody = document.querySelector(".contents")
	tbody.innerHTML = ''
	list.forEach(program => {
		tbody.innerHTML += `
            <td>${program.code}</td>
            <td>${program.title}</td>
            <td>${program.uploadDate.substring(0, 10)}</td>	
			<td><i class="fa-regular fa-trash-can" onclick="deleteProgram(${program.code})"></i></td>
            <td><i class="fa-regular fa-pen-to-square" onclick="modifyProgram('${programTheme}', ${program.code})"></i></td>
			
		`
	})
}

function AddProgram() {
	window.location.href = "/admin/program/add"
}

function modifyProgram(theme, code) {
	window.alert(theme + "의 " + code + "번 code로 이동")
	window.location.href = "/admin/program-" + theme + "/modify?code=" + code
}

function deleteProgram(code) {
	var result = window.confirm("정말로 삭제하시겠습니까?");
	if (result) {
		$.ajax({
			type: "DELETE",
			url: "/admin/api/program/delete/" + code,
			success: (response) => {
				if(response) { 
					window.alert("삭제가 완료되었습니다. 메인으로 이동합니다")
					location.href = "/admin"
				}
				else {
					console.log("응답은 처리되었으나 false를 반환")
				}
			},
			error: (error) => {
				console.log(error)
			}
		})
	} else {
		window.alert("삭제를 취소했습니다.")
	}
}
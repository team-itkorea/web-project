function load(nowPage) {
	$.ajax({
		async: false,
		type: "get",
		url: "/program/leisure/list/" + nowPage,
		data: {
			"searchFlag": searchFlag,
			"searchValue": searchValue
		},
		dataType: "json",
		success: (response) => {
			getList(response.data)
		},
		error: (error) => {
			console.log(error)
		}
	})
}

function getList(list) {
	const tbody = document.querySelector("tbody")
	tbody.innerHTML = ""
	list.forEach(notice => {
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
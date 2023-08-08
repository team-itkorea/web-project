
let nowPage =1;
load(nowPage);

function load(nowPage) {
	const searchFlag = document.querySelector(".search-form").value;
	const searchValue = document.querySelector(".search-input").value;
	
	$.ajax({
		async: false,
		type: "get",
		url: "/notice/main" + nowPage,
		data: {
			"searchFlag": searchFlag,
			"searchValue": searchValue
		},
		dataType: "json",
		success: (response) => {
			getList(response.data);
		},
		error: (error) => {
			console.log(error);
		}
		
	})
}

function getList(list) {
	const tbody = document.querySelector("tbody");
	tbody.innerHTML = "";
	list.forEach(notice => {
		tbody.innerHTML += `
	        <tr class="notice-row">
	            <td>${notice.noticeCode}</td>
	            <td>${notice.noticeTitle}</td>
	            <td>${notice.username}</td>
	            <td>${notice.createDate}</td>
	            <td>${notice.noticeCount}</td>
	        </tr>
		`;
		
	});
}

function getWriteButton() {
    const listFooter = document.querySelector(".write-now"); // 목록 아래 영역 요소를 찾습니다.
    const user = getUser();

    if (user != null && user.userRoles.includes("ROLE_ADMIN")) {
        // 사용자 정보가 있으며 사용자 역할 중 'ROLE_ADMIN'이 포함되어 있는 경우
        const writeButton = document.querySelector(".write-now");

        if (writeButton) {
            writeButton.style.display = "block"; // '공지 쓰기' 버튼을 보이도록 설정합니다.
        } else {
            const newButton = document.createElement("button");
            newButton.setAttribute("type", "button");
            newButton.classList.add("write-now");
            newButton.id = "admin";
            newButton.innerHTML = '<a href="/notice/write">공지 쓰기</a>';

            listFooter.appendChild(newButton);
        }
    }
}

getWriteButton();
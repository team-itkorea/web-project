
const textArea = document.querySelector(".textarea");
const titleText = document.querySelector(".titletext");
let currentPage = 1;
load(currentPage);

function getData() {
			
	let boardContent = textArea.value;
	let boardTitle = titleText.value;
	
	let contentDate = {
		boardTitle,
		boardContent
	}
				
	$.ajax ({
		async: false,
		type:"post",
		url: "/board/writepro",
		contentType: "application/json",
		data : JSON.stringify(contentDate),
	/*	dataType: "json",*/
		success: (response) => {
			alert(response + "성공")
		},
		error : (error) => {
			console.log(contentDate + "요청실패");
		}
	});
}

// 페이지 로드 시점에 JavaScript 코드 실행
document.addEventListener("DOMContentLoaded", function() {
    const writeNowButton = document.querySelector(".write-now");
    
    writeNowButton.addEventListener("click", function() {
        location.href = "/board/write";
    });
});




/*const pageButtons = document.querySelectorAll(".page-button");

	for(let i = 0; i < pageButtons.length; i++) {
		const pageButton = pageButtons[i];
		pageButton.onclick = () => {
			const page = pageButton.getAttribute("data-page");
			currentPage = page;
			load(currentPage);	
			console.log(page);		
	};

}*/

document.addEventListener("DOMContentLoaded", function() {
    const pageButtons = document.querySelectorAll(".page-button");

    for (let i = 0; i < pageButtons.length; i++) {
        const pageButton = pageButtons[i];
        pageButton.onclick = () => {
            const page = pageButton.textContent; // 해당 버튼의 텍스트를 가져옴
            console.log("Clicked page:", page);
            load(page)
        };
    }
});


function load(page) {
	
	
    $.ajax({
        type: "GET",
        url: `/board/noticelist/${page}`,
		dataType: "json", 
        success: (response) => {
            getBoardList(response.data);
            console.log(response);
        },
        error: (error) => {
            console.log('Error:', error);
        }
    });
	
}


function getBoardList(data) {
	const tbody = document.querySelector(".notice-list")
	tbody.innerHTML = ''
	data.forEach(content => {
		const formattedDate = content.createDate.slice(0, 10);
		tbody.innerHTML += `
		<tbody>
            <tr>
                <td class="page-number">${content.boardCode}</td>
                <td class="notice-content">${content.boardTitle}</td>
                <td class="notice-date">${formattedDate}</td>
            </tr>
        </tbody>
		`
	})
	
}















	

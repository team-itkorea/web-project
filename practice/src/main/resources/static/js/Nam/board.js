const textArea = document.querySelector(".textarea");
const titleText = document.querySelector(".titletext");


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

$(document).ready(function() {
    const pageNumber = document.querySelector(".page-number");
	const noticeContent = document.querySelector(".notice-content");

    $.ajax({
        type: "GET",
        url: "/board/notice", // 엔드포인트 URL
        data: { type: pageNumber, page: noticeContent }, // 요청 파라미터
        success: function(response) {
            if (response.code === 1) {
                var list = response.data; // 게시판 목록 데이터
                // 여기서 list를 화면에 표시하거나 가공하는 작업을 수행
            } else {
                console.error("Failed to load board list.");
            }
        },
        error: function(xhr, status, error) {
            console.error("AJAX request failed:", error);
        }
    });
});
	

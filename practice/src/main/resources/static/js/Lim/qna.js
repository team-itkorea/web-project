
const titleText = document.querySelector(".titletext");
const textArea = document.querySelector(".textarea");

function getQnaData() {
			
	let QnaTitle = titleText.value;
	let QnaContent = textArea.value;
	
	let qnaData = {
		QnaTitle,
		QnaContent
	}
				
	$.ajax ({
		async: false,
		type:"post",
		url: "/qna/writepro",
		contentType: "application/json",
		data : JSON.stringify(qnaData),
		success: (response) => {
			alert(response + "성공???")
			console.log(JSON.stringify(qnaData) + "실패?");
		},
		error : (error) => {
			console.log(qnaData + "요청실패");
		}
	});
}
	


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
	


/*let oEditors = [];
    nhn.husky.EZCreator.createInIFrame({
     oAppRef: oEditors,
     elPlaceHolder: "ir1",
     sSkinURI: "/static/smarteditor/SmartEditor2Skin.html",
     fCreator: "createSEditor2"
});*/


const textArea = document.querySelector(".textarea");
const titleText = document.querySelector(".titletext");

let page = 1;
load();

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
		url: "/api/board/writepro",
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

function load() {
    $.ajax({
        type: "GET",
        url: "/api/board/noticelist/" + page,
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

function getBoardList(list) {
	const tbody = document.querySelector(".bbb")
	tbody.innerHTML = ''
	list.forEach(board => {
		tbody.innerHTML += `
            <tr>
                <td class="page-number">${board.boardCode}</td>
                <td class="notice-content">${board.boardTitle}</td>
                <td class="notice-date">${board.createDate}</td>
            </tr>
		`
	})
}

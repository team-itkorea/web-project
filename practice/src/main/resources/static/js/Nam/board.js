
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

function load() {

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
	console.log(tbody)
	tbody.innerHTML = ''
	data.forEach(content => {
		tbody.innerHTML += `
		<tbody>
            <tr>
                <td class="page-number">${content.board_code}</td>
                <td class="notice-content">${content.title}</td>
                <td class="notice-date">${content.create_date}</td>
            </tr>
        </tbody>
		`
	})
	
}

	

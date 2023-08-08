const submitButton = document.querySelector('.notice-button1');

submitButton.addEventListener('click', () => {
	const noticetitle = document.querySelector('.notice-title').value;
	console.log(noticetitle);
    const text = document.getElementById('ir1').value;
    
    // 서버로 전송할 데이터를 구성합니다.
    const dataToSend = {
        noticeTitle: noticetitle,
        ir1: text,
    };
    
    $.ajax({
        type: 'post',
        url: '/notice/write',
        contentType: "application/json",
        /* dataType: 'json', */
        data: JSON.stringify(dataToSend),
        success: (response) => {
            console.log(response.data);
            alert("등록완료");
            location.href = '/contact';
        },
        error: (error) => {
            console.log("요청 실패");
            console.log(error);
            console.log(dataToSend);
        }
    }); 
});






/*const submitButton = document.querySelector(".submit");

submitButton.onclick = () => {
    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
    const textarearValue = document.querySelector("#ir1").value;
    alert(textarearValue);
    
    let formData = new FormData(document.querySelector("form"));
    
    formData.append("userCode", getUser().user_code);
    
    formData.forEach((v, k) => {
		console.log("key: " + k);
		console.log("value: " + v);
	})
	
	
	
	$.ajax({
		async: false,
		type: "post",
		url: "/notice/write",
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
		success: (response) => {
			alert(response.data + "번 공지사항 작성완료")
			location.href = "/notice/detail/" + response.data;
		},
		error: (error) => {
			console.log(error);
		}
	})
    
}
*/








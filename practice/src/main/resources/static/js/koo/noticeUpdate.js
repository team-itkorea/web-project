let noticeCode = location.search.substring(location.search.lastIndexOf("=") + 1)

console.log("프로그램 코드: " + noticeCode)

updateData(); 

function updateData(noticeCode) {
	
/*$(".notice-listlis").on(function() {*/
/*  var noticeCode = $(this).data("content");
  console.log(noticeCode);
  */
    $.ajax({
        type: "GET",
        url: `/notice/list/findNotice/${noticeCode}`,
        data: {
			noticeCode:noticeCode
		},
		dataType: "json", 
        success: (response) => {
            /*findNoticeCode(response);*/
            console.log(response);
        },
        error: (error) => {
            console.log('Error:' , error);
        }
    })
/*})*/
}

/*function findNoticeCode(data) {
	document.querySelector(".notice-title").value = data.notice_title;
	const div = document.querySelector(".layout")
	div.innerHTML = ''
	data.forEach(content => {
		div.innerHTML += `
         <div>
            <input name="noticeTitle" type="text" placeholder="제목" class="notice-title">
            <div class="bar"></div>
            <textarea name="ir1" id="ir1" placeholder="내용을 입력해주세요" class="textarea"><p>${content.noticecontent}</p></textarea>
         </div>
		`
		})
}*/
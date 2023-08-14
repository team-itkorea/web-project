const text = document.querySelector(".textarea"); // 내용
const Irl = document.getElementById('ir1'); // 제목
let page = 1;
load();

function getData() {
			
	let noticeTitle = text.value;
	let ir1 = Irl.value;
	
	let contentDate = {
		noticeTitle,
		ir1
	}
				
	$.ajax ({
		async: false,
		type:"post",
		url: "/notice/write",
		contentType: "application/json",
		data : JSON.stringify(contentDate),
		success: (response) => {
			console.log(response)
			alert(response + "성공")
			location.href = '/notice/main';
		},
		error : (error) => {
			console.log(contentDate + "요청실패");
		}
	});
}

function load() {
    $.ajax({
        type: "GET",
        url: `/notice/main/noticelist/${page}`,
		dataType: "json", 
        success: (response) => {
            getNoticeList(response.data);
            console.log(response);
        },
        error: (error) => {
            console.log('Error:', error);
        }
    });
	
}
/*
function updateData() {
    $.ajax({
        type: "GET",
        url: `/notice/list/findNotice/${noticeCode}`,
		dataType: "json", 
        success: (response) => {
            updateNotice(response.data);
            console.log(response);
        },
        error: (error) => {
            console.log('Error:', error);
        }
    });
}
*/

function getNoticeList(data) {
	const tbody = document.querySelector(".notice-listlis")
	tbody.innerHTML = ''
	data.forEach(content => {
		tbody.innerHTML += `
		<tbody>
            <tr>
                <td class="notice-num">${content.noticeCode}</td>
                <td class="notice-title">${content.noticeTitle}</td>
                <td class="username">${content.username}</td>
                <td class="notice-date">${content.createDate.substring(0,10)}</td>
                <td><i class="fa-regular fa-trash-can" data-content=${content.noticeCode}></i></td>
                <td><button type="button" onclick="noticeUpdate(${content.noticeCode})"><i class="fa-regular fa-pen-to-square"></i></button></td>
            </tr>
        </tbody>
		`
		})

	$(".notice-listlis").on("click",".fa-regular.fa-trash-can", function() {
      var noticeCode = $(this).data("content");
      console.log(noticeCode);
      
	      $.ajax({
			async: false,
	        type: "delete",
	        url: `/notice/noticeDelete/${noticeCode}`,
			dataType: "json", 
	        success: (response) => {
	            console.log(response);
	            console.log(noticeCode)
	            location.reload();
	        },
	        error: (error) => {
	            console.log('Error:', error);
	        }
	    })
	})
}

function noticeUpdate(code) {
	window.alert("이동합니다")
	location.href = "/notice/update?code=" + code
}

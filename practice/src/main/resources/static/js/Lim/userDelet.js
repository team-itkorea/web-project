const userDeletButton = document.querySelector(".user-delet-button");

function userDeletButton(userCode) {
    $.ajax({
        type: "delete",
        url: `/auth/userdelet/${userCode}`,
        async: true, // 비동기 처리
        dataType: "json",
        success: (response) => {
            alert("회원탈퇴되었습니다.")
        },
        error: errorMessage
			
		
    });
}

function errorMessage(request, status,error) {
    alert("요청실패");
    console.log(request.status);
    console.log(request.responseText);
    console.log(error);
}
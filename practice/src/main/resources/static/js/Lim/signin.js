$(document).ready(function () {
  $(".final-find-id").click(function (event) {
    event.preventDefault();

    const emailInput = document.querySelector(".email-input").value;
	const phoneInput = document.querySelector(".phone-input").value;

    var requestData = {
      userName: emailInput,
      userPhone: phoneInput,
    };

    $.ajax({
      type: "POST",
      url: "/auth/findEmail",
      contentType: "application/json",
      data: JSON.stringify(requestData),
      success: (response) => {
        alert("이메일: " + response);
        console.log("보냄?")
      },
      error: (error) => {
        $(".result").text("에러 발생: " + error);
        alert("이름과 전화번호를 다시 입력해주세요");
      },
    });
  });
});

$(document).ready(function () {
    $(".final-find-password").click(function (event) {
        event.preventDefault();

        const emailInput = document.querySelector(".id-find input").value;

        const requestData = {
            userEmail: emailInput,
        };

        $.ajax({
            type: "POST",
            url: "/auth/checkEmail", // 이메일 확인을 처리하는 서버 URL로 변경해야 함
            contentType: "application/json",
            data: JSON.stringify(requestData),
            success: (response) => {
				console.log("확인!")
                if (response === "Useer not found") {
					$("#resetPasswordResult").text("해당 이메일이 존재하지 않습니다.");
                    $("#resetPasswordResult").show();
                   
                } else {
                    $(".reset-password-modal").show();
                    $(".id-find").hide();
                    $(".final-find-password").hide();
                    $("#resetPasswordResult").hide();
                }
            },
            error: (xhr, status, error) => {
                alert("없는 이메일입니다. 다시 입력해주세요.");
            },
        });
    });

});

$(document).ready(function () {
    $(".reset-password-button").click(function (event) {
        event.preventDefault();

        const newPassword = document.querySelector("#newPassword").value;
		const confirmPassword = document.querySelector("#confirmPassword").value;
		const userEmail = document.querySelector(".id-find input").value;
        
        if(newPassword !== confirmPassword){
			$("#resetPasswordResult").text("비밀번호가 일치하지 않습니다.");
            $("#resetPasswordResult").show();
		} else {
			const newpasswordData = {
            newPassword,
            userEmail
        };

        $.ajax({
            type: "POST",
            url: "/auth/resetPassword", // 이메일 확인을 처리하는 서버 URL로 변경해야 함
            contentType: "application/json",
            data: JSON.stringify(newpasswordData),
            success: (response) => {
				console.log("성공!")
				console.log(response.data)
				alert("비밀번호 변경되었습니다.")
				location.replace("/auth/signin");
				/* window.location.href = "/login"; */ 
                
            },
            error: (xhr, status, error) => {
                alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
            },
        });
        }
    });
	
});    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

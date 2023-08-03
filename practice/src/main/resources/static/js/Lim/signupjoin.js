const signupButton = document.querySelectorAll("button")[0];
const inputs = document.querySelectorAll("input");

let chexkUseremailFlag = false;

function isValidEmail(email) {
	const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return emailRegex.test(email);
}

inputs[1].onblur = () => {
	const userEmail = inputs[1].value;
	
	if(!isValidEmail(userEmail)) {
		alert("유효한 이메일 형식이 아닙니다.")
		return;
	}
	$.ajax({
		async: false,
		type: "get",
		url: "/auth/useremail",
		data: {userEmail: inputs[1].value},
		dataType: "json",
		success: (response) => {
			chexkUseremailFlag = response.data;
			if(chexkUseremailFlag) {
				alert("사용 가능한 이메일입니다.")
			}else{
				alert("이미 사용중인 이메일입니다.")
			}
		},
		error: (error) => {
			if(error.status == 400) {
					alert(JSON.stringify(error.responseJSON.data));
				}else {
					console.log("요청실패");
					console.log(error);
				}
		}
	})
}

document.addEventListener("DOMContentLoaded", 
	function() {
		
		
		signupButton.onclick = () => {
			let userEmail = inputs[1].value;
	        let userName = inputs[4].value;
	        let userPassword = inputs[2].value;
	        let userAddress1 = inputs[8].value;
	        let userAddress2 = inputs[9].value;
	        let userPhone = inputs[7].value;
	        let userGenderValue = document.querySelector('input[name=userGender]:checked');
	        let userbirth1 = document.querySelector("#birth_a").value;
	        let userbirth2 = document.querySelector("#birth_b").value;
	        let userbirth3 = document.querySelector("#birth_c").value;
	
	        // 필수 입력 항목 검증
	        if (!userEmail || !userName || !userPassword || !userAddress1 || !userPhone || !userGenderValue || !userbirth1 || !userbirth2 || !userbirth3) {
	            alert("모든 항목을 입력하세요.");
	            return;
	        }
	
	        userGenderValue = userGenderValue.value;
	        let userBirth = userbirth1 + ", " + userbirth2 + ", " + userbirth3;
	
	        let signupData = {
	            userName: userName,
	            userEmail: userEmail,
	            userPassword: userPassword,
	            userAddress: userAddress1 + ", " + userAddress2,
	            userPhone: userPhone,
	            userGender: parseInt(userGenderValue, 10),
	            userBirth: userBirth
	        };
			
			$.ajax({
				async: false,
				type: "post",
				url : "/auth/signup",
				contentType: "application/json",
				data : JSON.stringify(signupData),
				dataType : "json",
				success : (response) => {
					if(response && response.data) {
						alert("회원가입완료");
						location.replace("/auth/signin");
					}
					
					
				},
				error : (error) => {
					if(error.status == 400) {
						alert(JSON.stringify(error.responseJSON.data));
					}else {
						console.log("요청실패");
						console.log(error);
					}
				}
			})
		}
	}
)





function check_pw() {
	var pw = document.getElementById('user-password').value;
	var SC = ["!","@","#","$","%"];
	var check_SC = 0;

	if(pw.length < 6 || pw.length>16){
		window.alert("비밀번호는 6글자 이상 16글자 이하만 이용 가능합니다.");
		document.getElementById('user-password').value='';
	}
	for(var i =0; i<SC.length; i++) {
		if(pw.indexOf(SC[i]) != -1) {
			check_SC = 1;
		}
	}
	if(check_SC == 0) {
		window.alert("!,@,#,$,%의 특수문자가 들어가 있지 않습니다.");
		document.getElementById('user-password').value='';
	}
	if(document.getElementById('user-password').value !='' && document.getElementById('user-password-check').value !=''){
		if(document.getElementById('user-password').value == document.getElementById('user-password-check').value){
			document.getElementById('check').innerHTML="비밀번호가 일치합니다."
			document.getElementById('check').style.color='blue';
		}
		else{
			document.getElementById('check').innerHTML="비밀번호가 일치하지 않습니다."
			document.getElementById('check').style.color='red';
		}
	}

}
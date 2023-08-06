function getUserData() {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: "get",
            url: "/auth/principal",
            dataType: "json",
            success: (response) => {
                const user = response.data;
                displayUserInfo(user);
                resolve(user.user_code); // userCode를 반환해줍니다.
                mypageusername(response.data.user_name);
            },
            error: (error) => {
                console.log(error);
                reject(null); // 에러 발생 시 null을 반환합니다.
            }
        });
    });
}

function mypageusername(user_name) {
    const mypagename = document.querySelector(".introduce");
    if (mypagename) {
        mypagename.innerHTML = `<h3>${user_name}님 안녕하세요</h3><p>누적 구매금액: 0</p>`;
    }
}


function displayUserInfo(user) {
    // 사용자 정보를 가져와서 해당 HTML 요소들에 값으로 넣어줍니다.
    const userCode = user.user_code;
    document.getElementById('userEmail').value = user.user_email;
    document.getElementById('userName').value = user.user_name;
    
    if (user.user_gender === 0) {
		  document.getElementById('userGender1').checked = true; // user_gender가 0인 경우 userGender1에 0 할당
		  document.getElementById('userGender2').checked = false; // user_gender가 0인 경우 userGender2는 빈 문자열로 처리
		} else if (user.user_gender === 1) {
		  document.getElementById('userGender1').checked = false; // user_gender가 1인 경우 userGender1은 빈 문자열로 처리
		  document.getElementById('userGender2').checked = true; // user_gender가 1인 경우 userGender2에 1 할당
		}
    
    document.getElementById('userPhoneNumber').value = user.user_phone;
    // 주소를 두 개의 입력 필드로 분리한 경우
    const [address1, address2] = user.user_address.split(', ');
    document.getElementById('userAddress1').value = address1;
    document.getElementById('userAddress2').value = address2;
    // 생년월일을 셀렉트 박스로 나눠서 표시
    const [year, month, day] = user.user_birth.split(', ');
    let month2 = month;
    document.getElementById('year').value = year;
    document.getElementById('month').value = month2;
    document.getElementById('day').value = day;

    return userCode;
}

document.addEventListener('DOMContentLoaded', async function () {
    console.log('DOMContentLoaded 이벤트 발생.');
    try {
        const userCode = await getUserData(); // 사용자 정보를 받아오고 userCode를 얻습니다.
        const confirmButton = document.querySelector(".confirm-button");


        confirmButton.onclick = function () {
            const userEmail = document.getElementById('userEmail').value;
            const userName = document.getElementById('userName').value;
            const userGender = document.querySelector('input[name="name1"]:checked').value;
            const userPhoneNumber = document.getElementById('userPhoneNumber').value;
            const userAddress1 = document.getElementById('userAddress1').value;
            const userAddress2 = document.getElementById('userAddress2').value;
            const year = document.getElementById('year').value;
            const month = document.getElementById('month').value;
            const day = document.getElementById('day').value;
            

            const userInfo = {
                user_email: userEmail,
                user_name: userName,
                user_gender: parseInt(userGender,10),
                user_phone: userPhoneNumber,
                user_address: userAddress1 + ', ' + userAddress2,
                user_birth: year + ', ' + month + ', ' + day,
            };

            confirmButtonClick(userCode, userInfo);
        };
    } catch (error) {
        console.log(error);
    }
});

function confirmButtonClick(userCode, userInfo) {
    $.ajax({
        type: "put",
        url: `/auth/user/mypage/modification/${userCode}`,
        data: JSON.stringify(userInfo),
        contentType: "application/json",
        success: (response) => {
            console.log(response.data);
            window.alert("수정 성공");
        },
        error: (error) => {
            console.log(error);
        },
    });
}

document.addEventListener('DOMContentLoaded', function() {
	const userDeletButton = document.querySelector(".drop-user-now");
	
	function deleteUser(userCode) {
    $.ajax({
        type: "delete",
        url: `/auth/user/mypage/userdelete/${userCode}`,
        async: true, // 비동기 처리
        dataType: "json",
        success: (response) => {
            alert("회원탈퇴되었습니다.")
            window.location.href = "/";
        },
        error: errorMessage
    	});
	}
		function errorMessage(request, status, error) {
		    alert("요청실패");
		    console.log(request.status);
		    console.log(request.responseText);
		    console.log(error);
		}
			userDeletButton.onclick = () => {
				 getUserData().then((userCode) => {
				     if (userCode) {
				         deleteUser(userCode);
		         }
    		});
	};

})









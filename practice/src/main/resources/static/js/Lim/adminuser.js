$(document).ready(function() {
    
    $.ajax({
        url: "/admin/List/user",
        type: "GET",
        dataType: "json",
        success: function(data) {
            updateTable(data);
            console.log(data);
        },
        error: function() {
            console.log("API 요청 실패");
        }
    });

   
    function updateTable(data) {
        var tableBody = $(".board-table tbody");
        tableBody.empty();
       
        for (var i = 0; i < data.length; i++) {
			var userdata = data[i];
			console.log(userdata.length , "확인");
            var row = `
                <tr>
                    <td>${userdata.user_code}</td>
                    <td>${userdata.user_name}</td>
                    <td>${userdata.user_email}</td>
                    <td>${userdata.create_date.substring(0, 10)}</td>
                    <td><i class="fa-regular fa-trash-can" data-usercode="${userdata.user_code}"></i></td>
                    <td><i class="fa-regular fa-pen-to-square" data-usercode="${userdata.user_code}"></i></td>
                </tr>
            `;
            tableBody.append(row); 
        }
    }
    $(".board-table tbody").on("click",".fa-regular.fa-trash-can", function() {
		var userCode = $(this).data("usercode");
		console.log(userCode);
		
		$.ajax({
			type: "delete",
			url: `/admin/list/userdelete/${userCode}`,
			dataType:"json",
			success:(response) => {
				alert("회원 삭제되었습니다.")
				console.log(response);
				location.reload();
			},
			error:(error) => {
				alert("요청 실패");
				console.log(error)
			}
		})
	})
	
	$(".board-table tbody").on("click",".fa-regular.fa-pen-to-square", function() {
		var userCode = $(this).data("usercode");
		console.log(userCode);
		
		$.ajax({
			type: "GET",
			url: `/admin/list/getUser/${userCode}`,
			dataType:"json",
			success:(response) => {
				
				const user = response.data;
				adminUser(user);
				console.log(response);
				console.log(user);
				//location.reload();
			},
			error:(error) => {
				alert("요청 실패");
				console.log(error)
			}
		})
		
		function adminUser(user) {
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
	    /*month2 = month2.substring(0, month2.length - 1);*/
	    console.log(month2+"확인")	;
	    document.getElementById('year').value = year;
	    document.getElementById('month').value = month2;
	    document.getElementById('day').value = day;
	
	    return userCode;
		}
	})
});


const submitButton = document.getElementById('submitButton');

submitButton.addEventListener('click', () => {
    // 선택된 라디오 버튼의 값을 가져옵니다.
	const selectedRadioValue = document.querySelector('input[name="contact_category"]:checked').value;
    // 기타 입력 필드의 값을 가져옵니다.
    const etcInputValue = document.getElementById('inputField').value;
	const username = document.getElementById('usernameInput').value;
	console.log(username);
    const phone1 = document.getElementById('phone1').value;
    const phone2 = document.getElementById('phone2').value;
    const phone3 = document.getElementById('phone3').value;
    const userPhone = `${phone1}-${phone2}-${phone3}`;
    const userEmail = document.getElementById('emailInput').value;
    const content = document.getElementById('contentInput').value;
    const agreeCheckbox = document.getElementById('agreeCheckbox');
    const agreeValue = agreeCheckbox.checked ? 1 : 0;
    
    // 서버로 전송할 데이터를 구성합니다.
    const dataToSend = {
        contact_category: selectedRadioValue === '기타' ? '기타' : selectedRadioValue,
        etc: selectedRadioValue === '기타' ? etcInputValue : null,
        name: username,
        userphone: userPhone,
        useremail: userEmail,
        contact_content: content,
        contact_agree: agreeValue,
    };
    
    $.ajax({
        type: 'post',
        url: '/contact/form',
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
    

window.addEventListener('load', function() {
	
	// 첫 페이지 로딩시 모달창 숨김후 정보수정을 누르면 모달창 보임
	var usermodifyForm = document.querySelector(".usermodify-form");
	var wrap = document.querySelector("#wrap");
    usermodifyForm.style.display = 'none';
    wrap.style.position = 'absolute';
    
    document.querySelector(".user-modify").addEventListener('click', function() {
        usermodifyForm.style.display = 'block';
        wrap.style.position = 'fixed';
    });
     
    document.querySelector(".ibutton").addEventListener('click', function() {
        usermodifyForm.style.display = 'none';
        wrap.style.position = 'absolute';
    });
    
    // 리스트 클릭시 밑줄
    
     // 각 글자를 클릭하면 핑크색 밑줄이 생기도록 처리하는 함수
    function addPinkUnderline(event) {
      var clickedText = event.target;
      clickedText.classList.add('pink-underline');

      // 다른 clickable-text 요소들의 밑줄 제거
      var clickableTexts = document.querySelectorAll('.click-bar');
      clickableTexts.forEach(function(textElement) {
        if (textElement !== clickedText) {
          textElement.classList.remove('pink-underline');
        }
      });
    }

    // 이벤트 리스너를 등록하여 함수를 실행합니다.
    var clickableTexts = document.querySelectorAll('.click-bar');
    clickableTexts.forEach(function(textElement) {
      textElement.addEventListener('click', addPinkUnderline);
    });
    
    
    
    
    // select 박스 만들기
    var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
    //년도 selectbox만들기               
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '</option>');    
    }

    // 월별 selectbox 만들기            
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '</option>');    
    }
    
    // 일별 selectbox 만들기
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="' + dd + '">' + dd+ '</option>');    
    }
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true");       

    // 연결해제
    $('.naver-connect p').click(function() {
        $(this).text('네이버 연결 해제');
    })

    $('.google-connect p').click(function() {
        $(this).text('Google 연결 해제');
    })

    $('.kakao-connect p').click(function() {
        $(this).text('카카오 연결 해제');
    })
});



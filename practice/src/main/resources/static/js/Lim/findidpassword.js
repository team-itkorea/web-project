window.addEventListener('load', function() {
	
	// 첫 페이지 로딩시 모달창 숨김후 정보수정을 누르면 모달창 보임
	var modal = document.querySelector("#modal");
	var wrap = document.querySelector("#wrap");
    modal.style.display = 'none';
    wrap.style.position = 'absolute';
    
    document.querySelector(".find-user-id-password").addEventListener('click', function() {
        modal.style.display = 'block';
        wrap.style.position = 'fixed';
    });
     
    document.querySelector(".ibutton").addEventListener('click', function() {
        modal.style.display = 'none';
        wrap.style.position = 'absolute';
    });
    
    /* ********* */
    $(".find-id-click").click(function () {
	      $(".find-id").show();
	      $(".find-password").hide();
	      $(".phone-find").hide();
	    });
	
	    $(".find-password-click").click(function () {
	      $(".find-password").show();
	      $(".find-id").hide();
	    });
	    
	    $(".radio-phone").click(function () {
	      $(".email-input-first").hide();
	      $(".phone-find").show();
	    });
	
	    $(".radio-email").click(function () {
	      $(".email-input-first").show();
	      $(".phone-find").hide();
	    });
	


});
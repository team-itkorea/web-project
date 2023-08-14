window.addEventListener('load', function() {
	var usermodifyForm = document.querySelector(".usermodify-form");
	
	usermodifyForm.style.display = 'none';
    
    var penToSquareIcons = document.querySelectorAll(".fa-regular.fa-pen-to-square");

	penToSquareIcons.forEach(function(icon) {
	    icon.addEventListener('click', function() {
	        usermodifyForm.style.display = 'block';
	    });
	});
    
     document.querySelector(".ibutton").addEventListener('click', function() {
        usermodifyForm.style.display = 'none';
        wrap.style.position = 'absolute';
    });
    
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
})
	


$(document).ready(function() {
	loadOrdersAndDisplay();
	
    $(".click-bar1").on("click", function() {
		loadOrdersAndDisplay();
		});
		
	function loadOrdersAndDisplay() {
		 $.ajax({
            type: "GET",
            url: "/auth/programData",
            dataType: "json",
            success: function(response) {
                displayOrders(response);
                orderTitle();
            },
            error: function(error) {
                console.log("API 요청 실패:", error);
            }
        });
    
	}
       

    // 주문 정보 출력 함수	
    function displayOrders(orders) {
        var ordersDiv = $(".order-title-list");
        ordersDiv.empty(); // 기존 내용 비우기

        // 주문 정보를 순회하며 출력
        for (var i = 0; i < orders.length; i++) {
            var order = orders[i];
            console.log(order.program_imgUrl_1);
            var orderInfo = `
          <div class="order-sige" id="orders">
	            <div class="content">
	                <div class="img-section">
	                    <img class="order-img" src="/static/upload/program/${order.program_imgUrl_1}" alt="Image">
	                </div>
	                <div class="txt-section">
	                    <h3 class="program-name">주문 제목: ${order.program_title}</h3>
	                </div>
		            <div class="but-section">
				       <button class="order-button" data-ordercode="${order.order_code}" type="button" value="2">주문취소</button>
		            </div>
	            </div>
	       </div>
            `;
            ordersDiv.append(orderInfo);
        }
    };
    function orderTitle() {
		const heartname = $(".info");
		heartname.empty();
		const heart = `
			<h5>주문 조회</h5>
		`;
		heartname.append(heart);
	}

    // 주문 취소 버튼 클릭 이벤트 위임
    $(".order-title-list").on("click", ".order-button", function() {
        var orderCode = $(this).data("ordercode");
        var flagCode = $(this).val();
        
        const orderdata = {
			orderCode,
			flagCode
		}
		console.log(orderCode);
		console.log(flagCode);
        $.ajax({
            type: "PUT",
            url: `/mypage/cancel/${orderCode}`,
            data: JSON.stringify(orderdata),
            contentType: "application/json",
            success: function(response) {
                console.log(response);
                alert("주문이 취소 완료 되었습니다.");
                location.reload();
            },
            error: function(error) {
                console.log(error, "요청실패");
                alert("주문 취소에 실패했습니다.");
            }
        });
    });
});



$(document).ready(function() {

$(".click-bar3").on("click", function() {
        $.ajax({
            type: "GET",
            url: "/auth/cancelOrders", // 취소 조회 API의 URL
            dataType: "json",
            success: function(response) {
                displayCanceledOrders1(response);
                canceleTitle();
                console.log(response);
            },
            error: function(error) {
                console.log("API 요청 실패:", error);
            }
        });
    });

    // 취소된 주문 정보 출력 함수
    function displayCanceledOrders1(orders) {
        
        const order1 = $(".order-title-list");
        order1.empty(); 
        // 취소된 주문 정보를 순회하며 출력
        for (var i = 0; i < orders.length; i++) {
            var order = orders[i];
            console.log(order + "확인1");
            var orderInfo1 = `
            <div class="order-sige" id="orders">
	            <div class="content">
	                <div class="img-section">
	                	<img class="order-img" src="/static/upload/program/${order.program_imgUrl_1}" alt="Image">
	          		</div>
	          		<div class="txt-section">
	                    <h3 class="program-name">주문 제목: ${order.program_title}</h3>
	                </div>
	             </div>
	         </div>
            `;
            order1.append(orderInfo1);
        }
    }
    function canceleTitle() {
		const heartname = $(".info");
		heartname.empty();
		const heart = `
			<h5>취소 조회</h5>
		`;
		heartname.append(heart);
	}

});

$(document).ready(function() {
    $(".click-bar2").on("click", function() {
        $.ajax({
            type: "GET",
            url: "/auth/heartList",
            dataType: "json",
            success: (response) => {
                displayCanceledOrders2(response);
                heartTitle();
                console.log(response,"좋아요 리스트");
            },
            error: (error) => {
                console.log("API 요청 실패:", error);
            }
        });
    });
     function displayCanceledOrders2(orders) {
        
        const heart = $(".order-title-list");
        heart.empty(); 
       
        for (var i = 0; i < orders.length; i++) {
            var order = orders[i];
            var orderInfo2 = `
            <div class="order-sige" id="orders">
	            <div class="content">
	                <div class="img-section">
	                	<img class="order-img" src="/static/upload/program/${order.program_imgUrl_1}" alt="Image">
	          		</div>
	          		<div class="txt-section">
	                    <h3 class="program-name">주문 제목: ${order.program_title}</h3>
	                </div>
	             </div>
	         </div>
            `;
            heart.append(orderInfo2);
        }
    }
    function heartTitle() {
		const heartname = $(".info");
		heartname.empty();
		const heart = `
			<h5>위시 리스트</h5>
		`;
		heartname.append(heart);
	}
});

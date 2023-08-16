let programCode = location.search.substring(location.search.lastIndexOf("=") + 1)

console.log("프로그램 코드: " + programCode)

load("/api/program/detail/")

function load(uri) {
	$.ajax({
		type: "GET",
		url: uri + programCode,
		dataType: "json",
		success: (response) => {
			console.log(response.data)
			getDetail(response.data)
			heartCheck(programCode)
		},
		error: (error) => {
            console.log(error)
        }
	})
}

function getDetail(detail) {
    const img1 = document.querySelector(".summary-img")
    const img2 = document.querySelector(".big-img")
    const themeAndtitle = document.querySelector(".header-title-state")
    const price = document.querySelector(".header-price-share")
    const buyAndlike = document.querySelector(".submit-buttons")
    const info = document.querySelector(".item-info")

    const place = document.querySelector(".program-place")
    const schedule = document.querySelector(".program-schedule")
    const time = document.querySelector(".program-time")
    const participants = document.querySelector(".program-participants")
    
    const options = document.querySelector(".option")
    const optionValues = `${detail.program_option}`
    const valuesArray = optionValues.split(",");

    for (let i = 0; i < valuesArray.length; i++) {
        options.innerHTML += `
            <option value="option${i}">${valuesArray[i]}</option>
        `
    }

    img1.innerHTML = `
        <img src="/static/upload/program/${detail.program_imgUrl_1}">
    `
    img2.innerHTML = `
        <img src="/static/upload/program/${detail.program_imgUrl_2}">
    `
    themeAndtitle.innerHTML = `
        <p class="program-theme">[${detail.program_theme}]</p>
        <p class="program-title">${detail.program_title}</p>
    `
    price.innerHTML = `
        <h2 class="program-price">${detail.program_price}</h2>
    `
    info.innerHTML = `
        <p class="program-info">${detail.program_info}</p>
    `
    place.innerHTML = `
    	<p>${detail.program_place}</p>
    `
    schedule.innerHTML = `
    	<p>${detail.program_schedule}</p>
    `
    time.innerHTML = `
    	<p>${detail.program_time}</p>
    `
    participants.innerHTML = `
    	<p>${detail.program_participants}</p>
    `
    buyAndlike.innerHTML = `
        <button type="button" class="buy" onclick="order()">구매</button>
        <button type="button" class="like" onclick="Heart()">${detail.program_heart}</button>
    `
}

function heartCheck(code) {
    $.ajax({
        type: "GET",
        url: "/api/program/heartCheck/" + code,
        dataType: "json",
        success: (response) => {
            console.log(response.data)
            heartStatus(response.data)
        },
        error: (error) => {
            console.log(error)
        }
    })
}

function heartStatus(user) {
	const like = document.querySelector(".like")
    if(user != null) {  // 사용자가 해당 프로그램에 좋아요를 눌렀다면
        like.setAttribute("style", "background-color: black; color: white;")
        console.log("버튼 검은색으로")
    }else {
        like.setAttribute("style", "background-color: white; color: black;")
        console.log("버튼 그대로")
    }
}

function Heart() {
    const like = document.querySelector(".like")
    if(like.style.color === "white") {
        console.log("좋아요 취소로 이동")
        heartCancel(programCode)
    }else if(like.style.color === "black") {
        console.log("좋아요 추가로 이동")
        heartCreate(programCode)
    }
}

function heartCreate(code) {
    const like = document.querySelector(".like")
    $.ajax({
        type: "POST",
        url: "/api/program/heartCreate/" + code,
        success: (response) => {
            console.log(response)
            if(response == true) {
                console.log("DB에 성공적으로 추가됨")
                // like.setAttribute("style", "background-color: black; color: white;")
                location.reload()
            }else {
                window.alert("로그인이 필요한 작업입니다.")
            }
        },
        erorr: (error) => {
            console.log(error)
        }
    })
}

function heartCancel(code) {
    const like = document.querySelector(".like")
    $.ajax({
        type: "DELETE",
        url: "/api/program/heartCancel/" + code,
        success: (response) => {
            console.log(response)
            if(response == true) {
                console.log("DB에 성공적으로 삭제됨")
                // like.setAttribute("style", "background-color: white; color: black;")
                location.reload()
            }else {
                window.alert("로그인이 필요한 작업입니다.")
            }
        },
        erorr: (error) => {
            console.log(error)
        }
    })
}

function order() {
    $.ajax({
        type: "POST",
        url: "/api/program/order/" + programCode,
        success: (response) => {
            if(response == true) {
                window.alert("구매 성공!")
            }else {
                window.alert("로그인이 필요한 작업입니다.")
            }
        },
        error: (error) => {
            console.log(error)
        }
    })
}

function scrollToSection(sectionId) {
    var section = document.querySelector(sectionId);
    if (section) {
        var yOffset = section.getBoundingClientRect().top + window.pageYOffset;
        window.scrollTo({ top: yOffset, behavior: 'smooth' });
    }
}


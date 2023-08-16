let programCode = location.search.substring(location.search.lastIndexOf("=") + 1)

console.log("프로그램 코드: " + programCode)

load("/admin/api/program/modify/")

function load(uri) {
	$.ajax({
		type: "GET",
		url: uri + programCode,
		dataType: "json",
		success: (response) => {
			console.log(response.data)
            getDetail(response.data)
		},
		error: (error) => {
            console.log(error)
        }
	})
}

function getDetail(program) {
    const theme = document.querySelector(".theme")
    const title = document.querySelector(".title")
    const price = document.querySelector(".price")
    const info = document.querySelector(".info")
    const place = document.querySelector(".place")
    const schedule = document.querySelector(".schedule")
    const time = document.querySelector(".time")
    const participants = document.querySelector(".participants")
    const occasion = document.querySelector(".occasion")

    let optionValue = `${program.program_theme}`
    if(optionValue === "일상 탐험") { optionValue = "leisure" }
    else if(optionValue === "웰니스 클럽") { optionValue = "wellness" }

    for (let i = 0; i < theme.options.length; i++) {
        if (theme.options[i].value === optionValue) {
           theme.options[i].selected = true;
           break;
        }
    }

    theme.disabled = true

    title.value = `${program.program_title}`
    price.value = `${program.program_price}`
    info.value = `${program.program_info}`
    place.value = `${program.program_place}`
    schedule.value = `${program.program_schedule}`
    time.value = `${program.program_time}`
    participants.value = `${program.program_participants}`

    const str = `${program.program_option}`

    const values = str.split(",");

    values.forEach(value => {
        const li = document.createElement("li");
        li.textContent = value;
        li.value = value;
        occasion.appendChild(li);
    });
}

function back_Add() {
	var new_p = document.createElement("li")
	var nameValue = document.getElementsByName("intext")[0]
	var new_text = document.createTextNode(nameValue.value)

	new_p.appendChild(new_text)

	var outList = document.getElementsByName("out")[0]
	outList.appendChild(new_p)
	nameValue.value = ""
}

function front_Add() {
	var new_p = document.createElement("li")
	var nameValue = document.getElementsByName("intext")[0]
	var new_text = document.createTextNode(nameValue.value)

	new_p.appendChild(new_text)

	var outList = document.getElementsByName("out")[0]
	outList.insertBefore(new_p, outList.childNodes[0])
	nameValue.value = ""
}

function Reset() {
	var outList = document.getElementsByName("out")[0]
	while (outList.hasChildNodes()) {
		outList.removeChild(outList.childNodes[0])
	}
}

function delete_First() {
	var outList = document.getElementsByName("out")[0]
	if (outList.hasChildNodes()) {
		outList.removeChild(outList.childNodes[0])
	}
}

function delete_Final() {
	var outList = document.getElementsByName("out")[0]
	if (outList.hasChildNodes()) {
		outList.removeChild(outList.childNodes[outList.childNodes.length - 1])
	}
}

function getProgramData() {
    const title = document.querySelector(".title").value
    const price = document.querySelector(".price").value
    const info = document.querySelector(".info").value
    const place = document.querySelector(".place").value
    const schedule = document.querySelector(".schedule").value
    const time = document.querySelector(".time").value
    const participants = document.querySelector(".participants").value

    const options = document.querySelectorAll('div[name="out"] li')
	const option = [];
	options.forEach(li => {
		const textValue = li.textContent;
		option.push(textValue);
	});

	const programData = {
		title, price, info, place, schedule, time, participants,
        option: option
	};

	$.ajax({
		type: "PUT",
		url: "/admin/api/program/update/" + programCode ,
		data: JSON.stringify(programData),
		contentType: "application/json",
        success: (response) => {
            window.alert("수정에 성공했습니다.")
            location.href = "/admin"
        },
        error: (error) => {
            console.log(error)
        }
	});
}


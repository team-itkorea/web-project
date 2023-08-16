function getProgramData() {
	const formData = new FormData(document.querySelector('form'))

	const options = document.querySelectorAll('div[name="out"] li')
	const option = [];
	options.forEach(li => {
		const textValue = li.textContent;
		option.push(textValue);
	});

	formData.append("option", option)

	$.ajax({
		type: "POST",
		url: "/admin/api/newProgram",
		data: formData,
		cache: false,
		processData: false,
		contentType: false,
		success: (response) => {
			alert("추가 성공. Admin 메인페이지로 이동합니다.")
			location.href = "/admin"
		},
		error: (error) => {
			alert("추가 실패. 다시 확인하세요.")
		}
	});
}
	// const imgUrl_1 = document.querySelector('.a').files[0]
	// const imgUrl_2 = document.querySelector('.b').files[0]

	// const programData = {
	// 	theme, title, price, info, place, schedule, time, participants, option, like
	// };


	// $.ajax({
	// 	type: "POST",
	// 	url: "/admin/add/submit",
	// 	data: JSON.stringify(programData),
	// 	contentType: "application/json",
	// 	success: (response) => {
	// 		alert("추가 완료")
	// 	},
	// 	error: (error) => {
	// 		alert("추가 실패")
	// 	}
	// });

/*$("input[type='file']").on("change", function(e){
	let fileInput = $('input[name="uploadFile"]');
		let fileList = fileInput[0].files;
		let fileObj = fileList[0];

		console.log("fileList : " + fileList);
		console.log("fileObj : " + fileObj);
		console.log("fileName : " + fileObj.name);
		console.log("fileSize : " + fileObj.size);
		console.log("fileType(MimeType) : " + fileObj.type);
});*/


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

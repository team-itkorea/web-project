const modal = document.getElementById("myModal");
const btn = document.getElementById("openModalBtn");
const closeSpan = document.getElementsByClassName("close")[0];

btn.onclick = function () {
  modal.style.display = "block";
  document.body.classList.add("modal-open"); // 모달 열릴 때 body에 modal-open 클래스 추가
};

closeSpan.onclick = function () {
  modal.style.display = "none";
  document.body.classList.remove("modal-open"); // 모달 닫힐 때 body의 modal-open 클래스 제거
};

window.onclick = function (event) {
  if (event.target === modal) {
    modal.style.display = "none";
    document.body.classList.remove("modal-open"); // 모달 외부 클릭 시 body의 modal-open 클래스 제거
  }
};
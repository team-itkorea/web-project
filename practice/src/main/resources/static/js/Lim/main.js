
function checkLoginStatus() {
    $.ajax({
        type: "get",
        url: "/auth/principal",
        dataType: "json",
        success: (response) => {
            if (response.data !== null) {
                console.log(response.data.user_name + "확인1")
                showLoggedInUI(response.data.user_name);
            } else {
                showLoggedOutUI();
            }
        },
        error: (error) => {
            showLoggedOutUI();
        }
    });
}

function showLoggedInUI(user_name) {
    const loginNav = document.querySelector(".login");
    if (loginNav) {
        loginNav.innerHTML = `
        <p>${user_name}님</p><p><a href="/auth/user/logout">로그아웃</a></p><p><a href="/auth/mypage">마이페이지</a></p>
        `;
    }
}

function showLoggedOutUI() {
    const loginNav = document.querySelector(".login");
    if (loginNav) {
        loginNav.innerHTML = `<p><a href="/auth/signin">로그인</a></p><p><a href="/auth/signup">회원가입</a></p>`;
    }
}

// 페이지가 로딩되면 로그인 상태를 확인하여 UI를 변경합니다.
jQuery(document).ready(function () {
    checkLoginStatus();
});

function logout() {
    $.ajax({
		/*async: false,*/
        type: "GET",
        url: "/auth/user/logout",
        contentType: "application/json",
        success: (response) => {
            console.log("로그아웃 성공!");
            alert("로그아웃 되었습니다.")
            showLoggedOutUI();
            location.replace("/templates/Nam/main.html");
        },
        error: (error) => {
            console.error("로그아웃 실패!");
        }
    });
}

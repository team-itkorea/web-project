package com.example.practice.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthFailureHandler implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        System.out.println("Authentication failed with exception: " + exception.getClass().getName());
        System.out.println("Exception message: " + exception.getMessage());

        // 사용자에게 보여줄 실패 메시지 설정
        String errorMessage = "로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.";

        response.setContentType("text/html; charset=utf-8");
        response.getWriter().print("<html><head></head><body><script>alert(\"" + errorMessage + "\");history.back();</script></body></html>");
    }


}

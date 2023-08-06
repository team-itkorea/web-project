package com.example.practice.controller.Qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {

	@GetMapping("/auth/user/mypage/qna")
	public String addqna() {
		return "Lim/qna";
	}
}

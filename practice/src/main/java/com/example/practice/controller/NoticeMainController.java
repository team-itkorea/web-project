package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeMainController {
	
	@GetMapping("/main")
	public String noticemain() {
		return "/Koo/notice-main";
	}
	
//	admin만 공지 쓸 수 있게할 예정
	@GetMapping("/write")
	public String noticewrite() {
		return "/Koo/noticewrite";
	}

}

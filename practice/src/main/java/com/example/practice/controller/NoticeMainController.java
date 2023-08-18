package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeMainController {
	

	
//	admin만 공지 쓸 수 있게할 예정	
	@GetMapping("/write")
	public String noticewrite() {
		return "/Koo/noticewrite";
	}

	@GetMapping("/update")
	public String noticeUpdate(@RequestParam int code) {
		return "/Koo/noticeupdate";
	}

}

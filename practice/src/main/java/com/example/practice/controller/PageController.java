package com.example.practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.practice.auth.PrincipalDetailsService;
import com.example.practice.dto.SignupReqDto;
import com.example.practice.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
//@RequiredArgsConstructor
public class PageController {
	
//	private final PrincipalDetailsService principalDetailsService;
//	private final UserService userService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping({"", "/"})
	public String main() {
		return "Nam/main";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	// 스프링 시큐리티가 낚아채는 상황
	// SecurityConfig 생성 후 비활성화 할 것
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "Lim/signupjoin";
	}
	
	@GetMapping("/board/write")
	public String boardWriteForm() {
		return "/Nam/boardwrite";
	}
	
//	@PostMapping("/join")
//	public String join(@ModelAttribute SignupReqDto signupReqDto) {
//		String rawPassword = signupReqDto.getUserPassword();
//		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
//		signupReqDto.setUserPassword(encPassword);
//		userService.signup(signupReqDto);
//		return "redirect:/Lim/signupjoin";
//	}	
	
	
	
}

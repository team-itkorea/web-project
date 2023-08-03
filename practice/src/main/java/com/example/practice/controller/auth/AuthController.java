package com.example.practice.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.dto.SignupReqDto;
import com.example.practice.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
//@RequestMapping("/joinForm")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/join")
	public String join(@ModelAttribute SignupReqDto signupReqDto) {
		String rawPassword = signupReqDto.getUserPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		signupReqDto.setUserPassword(encPassword);
		userService.signup(signupReqDto);
		return "redirect:/Lim/signupjoin";
	}
	
	@GetMapping("/Lim/signupjoin")
	public String signupjoin() {
		return "Lim/signupjoin";
	}

}

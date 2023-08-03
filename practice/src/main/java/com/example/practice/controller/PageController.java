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
public class PageController {
	

	
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

	@GetMapping("/auth/signin")
   public String loginForm() {
      return "Lim/signin";
   }
   
   @GetMapping("/auth/signup")
   public String joinForm() {
      return "Lim/signupjoin";
   }
   @GetMapping("/auth/mypage")
   public String mypage() {
      return "mypage";
   }
   
   @GetMapping("/auth/mypage/userdelet")
   public String userdelet() {
      return "Lim/userdelet";
   }
   
   @GetMapping("/board/write")
   public String boardWriteForm() {
	   return "Nam/boardwrite";
   }
   
	
}

package com.example.practice.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/auth/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
        }
        return "redirect:/";
    }
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Nam/admin";
	}
	
	@GetMapping("/admin/program-{theme}")
	public String programList() {
		return "Kim/adminprogramList";
	}
	
	@GetMapping("/admin/program/add")
	public String programAddForm() {
		return "Kim/adminprogramAdd";
	}
	
	@GetMapping("/admin/program-{theme}/modify")
	public String programModify(@PathVariable String theme, @RequestParam int code) {
		return "Kim/adminprogramModify";
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
      return "Nam/mypage";
   }
   
   @GetMapping("/auth/mypage/userdelet")
   public String userdelet() {
      return "Lim/userdelet";
   }
   
   @GetMapping("/board/write")
   public String boardWriteForm() {
	   return "Nam/boardwrite";
   }
   
   @GetMapping("/board/noticelist")
   public String boardNotice(@RequestParam(name = "page", defaultValue = "1") int page) {
	   return "Nam/notice";
   }
   
	
}

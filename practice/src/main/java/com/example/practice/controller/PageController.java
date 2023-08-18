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
	
	
	@GetMapping("/admin")
	public String admin() {
		return "Nam/admin";
	}
	@GetMapping("/admin/userlist")
	public String adminuser() {
		return "Nam/admin-nonuser";
	}
	
   @GetMapping("/admin/contact-{category}")
   public String adminContact() {
      return "Koo/admin-contact";
   }
   @GetMapping("/admin/contact/check-{contactCode}")
   public String admincheck() {
      return "Koo/admin-contact-check";
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

   @GetMapping("/brand")
   public String goBrand() {
	   return "Nam/brand";
   }
	@GetMapping("/program")
	public String loadProgramMain() {
		return "Kim/programMain";
	}
	@GetMapping("/wellmate") 
	public String mate() {
		return "/Koo/mate";
	}
	@GetMapping("/item")
	public String item() {
		return "/Koo/item";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "/Koo/contact";
	}
	
	@GetMapping("/notice/main")
	public String noticemain(@RequestParam (name = "page", defaultValue="1") int page) {
		return "/Koo/notice-main";
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
   
   @GetMapping("/auth/agreement")
   public String agreement() {
	   return "Lim/agreement";
   }
   
   @GetMapping("/board/notice")
   public String boardNotice(@RequestParam (name = "page", defaultValue="1") int page) {
	   System.out.println("page 확인" + page);
	   return "Nam/board";
   }
   
	
}

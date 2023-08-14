//package com.example.practice.controller;
//
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.practice.auth.PrincipalDetails;
//
//@RestController
//public class HeartController {
//
//	@GetMapping("api/insert")
//	public @ResponseBody String getProfile(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		if (principalDetails != null) {
//            String username = principalDetails.getUsername();
//            return username;
//        } else {
//            return null;
//        }
//	}
//}

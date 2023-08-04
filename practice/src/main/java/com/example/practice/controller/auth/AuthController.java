package com.example.practice.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.auth.PrincipalDetails;
import com.example.practice.auth.PrincipalDetailsService;
import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.SignupReqDto;
import com.example.practice.dto.UpdateUserReqDto;
import com.example.practice.dto.UseremailCheckReqDto;
import com.example.practice.handler.aop.annotation.Log;
import com.example.practice.handler.aop.annotation.Timer;
import com.example.practice.handler.aop.annotation.ValidCheck;
import com.example.practice.service.UserService;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	private final PrincipalDetailsService principalDetailsService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody @Valid SignupReqDto signupReqDto, BindingResult bindingResult ) {
		boolean status = false;
		try {
			status = principalDetailsService.addUser(signupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패",status));
		}
		System.out.println(status);
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공",status));
	}
	
	@ValidCheck
	@Log
	@Timer
	@GetMapping("/useremail")
	public ResponseEntity<?> checkUseremail(@Valid UseremailCheckReqDto useremailCheckReqDto, BindingResult bindingResult) {
		boolean status = false;
		try {
			status = userService.checkUseremail(useremailCheckReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"서버 오류",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"회원가입 가능 여부",status));
	}
	
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		if(principalDetails == null) {
			System.out.println(principalDetails + "확인 2");
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"principal is null",null));
			
		}
		System.out.println(principalDetails + "확인1");
		return ResponseEntity.ok(new CMRespDto<>(1,"success load",principalDetails.getUser()));
	}
	
	@PutMapping("/user/mypage/modification/{userCode}")
	public ResponseEntity<?> userInfo(@PathVariable int userCode, @RequestBody UpdateUserReqDto updateUserReqDto) {
		boolean status = false;
		updateUserReqDto.setUser_code(userCode);
		System.out.println(status+ "확인1" + updateUserReqDto + "확인1");
		try {
			status = userService.updateUser(updateUserReqDto);
		} catch (Exception e) {
			System.out.println(updateUserReqDto + "확인 2");
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공",status));
	}
	
	@DeleteMapping("/auth/userdelet/{userCode}")
	public ResponseEntity<?> userdelet(@PathVariable int userCode){
		boolean status = false;
		try {
			status = userService.removeUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
	}
	
	  
	
}

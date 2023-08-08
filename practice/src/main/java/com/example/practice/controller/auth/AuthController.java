package com.example.practice.controller.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.practice.dto.ResetPassword;
import com.example.practice.dto.SignupReqDto;
import com.example.practice.dto.UpdateUserReqDto;
import com.example.practice.dto.UseremailCheckReqDto;
import com.example.practice.handler.aop.annotation.Log;
import com.example.practice.handler.aop.annotation.Timer;
import com.example.practice.handler.aop.annotation.ValidCheck;
import com.example.practice.service.UserService;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	private final PrincipalDetailsService principalDetailsService;
	private final UserRepository userRepository;
	
	@PostMapping("/signup") //로그인
	public ResponseEntity<?> signup(@RequestBody @Valid SignupReqDto signupReqDto, BindingResult bindingResult ) {
		boolean status = false;
		try {
			status = principalDetailsService.addUser(signupReqDto);
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패",status));
		}
		System.out.println(status);
		System.out.println("성공");
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
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"principal is null",null));
			
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"success load",principalDetails.getUser()));
	}
	
	@PutMapping("/user/mypage/modification/{userCode}")
	public ResponseEntity<?> userInfo(@PathVariable int userCode, @RequestBody UpdateUserReqDto updateUserReqDto) {
		boolean status = false;
		updateUserReqDto.setUser_code(userCode);
		try {
			status = userService.updateUser(updateUserReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "회원가입 실패",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공",status));
	}
	
	@DeleteMapping("/user/mypage/userdelete/{userCode}")
	public ResponseEntity<?> userdelet(@PathVariable int userCode){
		boolean status = false;
		System.out.println(userCode + "확인1");
		try {
			status = userService.removeUser(userCode);
			System.out.println(userCode + "확인2");
			System.out.println(status + "확인3");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
	}
	
	@PostMapping("/findEmail") //이름이랑,전화번호로 이메일 찾기
	public ResponseEntity<?> findEmail(@RequestBody Map<String,String> requestMap){
		String userName = requestMap.get("userName");
		String userPhone = requestMap.get("userPhone");
		
		try {
			User user = userRepository.findByNameAndUserPhone(userName,userPhone);
			if (user == null) {
				return ResponseEntity.badRequest().body("Useer not found");
			}
			return ResponseEntity.ok(user.getUser_email());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error.");
		}
	}
	
	@PostMapping("/checkEmail")
	public ResponseEntity<?> userEmailcheck(@RequestBody UseremailCheckReqDto useremailCheckReqDto){
		
		String userEmail = useremailCheckReqDto.getUserEmail();
		
		System.out.println(userEmail + " 들어왔나?");
		
		try {
			User user = userRepository.findByUseremail(userEmail);
			if(user == null) {
				return ResponseEntity.badRequest().body("Useer not found");
			}
			return ResponseEntity.ok(user.getUser_email());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error.");
		}
	}
	
	@PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody @Valid ResetPassword resetPassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	System.out.println(resetPassword+"확인1");
            return ResponseEntity.badRequest().body("Invalid input data");
        }

        try {
            boolean success = userService.resetPassword(resetPassword);
            System.out.println(resetPassword+"확인2");
            if (success) {
            	System.out.println(resetPassword+"확인3");
                return ResponseEntity.ok().body("Password reset successful");
            } else {
            	System.out.println(resetPassword+"확인4");
                return ResponseEntity.badRequest().body("Failed to reset password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while resetting password");
        }
    }
	  
	
}

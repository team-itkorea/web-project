package com.example.practice.controller.Admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.service.UserService;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {
	
	private final UserRepository userRepository;
	private final UserService userService;
	
	@GetMapping("/List/user") //모든 유저 가져오기
	public ResponseEntity<List<User>> getuserList(){
		
		try {
            List<User> userList = userRepository.findAll();
            System.out.println(userList);
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@DeleteMapping("/list/userdelete/{userCode}")  //유저 삭제
		public ResponseEntity<?> adminuserdelete(@PathVariable int userCode) {
			boolean status = false;
			try {
				status = userService.removeUser(userCode);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
			}
			
			return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
		}
	@GetMapping("list/getUser/{userCode}") //상세 정보
	public ResponseEntity<?> getadminuserlist(@PathVariable int userCode) {
		User user = null;
		try {
			user = userService.getUserByCode(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(user+"안들어옴?");
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",user));
		}
		System.out.println(user+"들어옴???");
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",user));
	}
}

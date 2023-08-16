package com.example.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.auth.PrincipalDetails;
import com.example.practice.dto.CMRespDto;
import com.example.practice.heart.Heart;
import com.example.practice.heart.HeartDto;
import com.example.practice.service.HeartService;
import com.example.practice.service.ProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HeartController {
	
	private final HeartService heartService;
	private final ProgramService programService;
	
	@GetMapping("api/userinfo")
	public @ResponseBody String getProfile(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		if (principalDetails != null) {
            String username = principalDetails.getUsername();
            return username;
        } else {
            return null;
        }
	}
	
	@GetMapping("/api/program/heartCheck/{code}")
	public ResponseEntity<?> heartCheck(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int code) {
		Heart heart = null;
		HeartDto dto = new HeartDto();
		
		if(principalDetails != null) {
			dto.setProgramcode(code);
			dto.setUsercode(principalDetails.getUser().getUser_code());
		}else {
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "failure", null));
		}
		
		heart = heartService.findHeart(dto);
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", heart));
	}
	
	@PostMapping("/api/program/heartCreate/{code}")
	public boolean heart(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int code) {
		boolean status1 = false;
		boolean status2 = false;
		HeartDto dto = new HeartDto();
		
		if(principalDetails != null) {
			dto.setProgramcode(code);
			dto.setUsercode(principalDetails.getUser().getUser_code());
		}else {
			return status1;
		}
		
		status1 = heartService.createHeart(dto);
		
		try {
			status2 = programService.addHeart(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status1 && status2;
	}
	
	@DeleteMapping("/api/program/heartCancel/{code}")
	public boolean unheart(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int code) {
		boolean status1 = false;
		boolean status2 = false;
		HeartDto dto = new HeartDto();
		
		if(principalDetails != null) {
			dto.setProgramcode(code);
			dto.setUsercode(principalDetails.getUser().getUser_code());
		}else {
			return status1;
		}
		status1 = heartService.cancelHeart(dto);
		
		try {
			status2 = programService.subHeart(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status1 && status2;
	}
}

package com.example.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProgramRestController {
	
	private final UserService userService;
	
	@GetMapping("/program/{theme}")
	public ResponseEntity<?> getProgramList(@PathVariable String theme) {
		
		ProgramListRespDto listRespDto = null;
		
		
		
		
		
		
		
		
		
		
		
		
		return ResponseEntity.ok(null);
	}
}
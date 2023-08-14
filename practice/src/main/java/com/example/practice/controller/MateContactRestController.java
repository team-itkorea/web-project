package com.example.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.ContactReqDto;
import com.example.practice.service.ContactService;

import lombok.RequiredArgsConstructor;

@RestController
//@RequestMapping("/")
@RequiredArgsConstructor
public class MateContactRestController {
	
	private final ContactService contactService;
	
	@PostMapping("/contact/form")
	public ResponseEntity<?> contactForm(@RequestBody ContactReqDto contactReqDto) {
		contactService.contact(contactReqDto);
//		System.out.println("gd");
		return ResponseEntity.ok(null);
	}
	
}

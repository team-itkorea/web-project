package com.example.practice.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.dto.ContactReqDto;
import com.example.practice.service.ContactService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MateContactController {

	


	
	@GetMapping("/wellmate/1")
	public String wella() {
		return "/Koo/well1";
	}
	
	@GetMapping("/wellmate/2")
	public String wellb() {
		return "/Koo/well2";
	}
	
	@GetMapping("/wellmate/3")
	public String wellc() {
		return "/Koo/well3";
	}
	
	@GetMapping("/wellmate/4")
	public String welld() {
		return "/Koo/well4";
	}
}

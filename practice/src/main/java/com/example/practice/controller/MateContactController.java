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
	
	@GetMapping("/templates/Koo/well1.html")
	public String wella() {
		return "/Koo/well1";
	}
	
	@GetMapping("/templates/Koo/well2.html")
	public String wellb() {
		return "/Koo/well2";
	}
	
	@GetMapping("/templates/Koo/well3.html")
	public String wellc() {
		return "/Koo/well3";
	}
	
	@GetMapping("/templates/Koo/well4.html")
	public String welld() {
		return "/Koo/well4";
	}
}

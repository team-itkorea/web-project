package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WellMate {
	
	@GetMapping("/wellmate") 
	public String mate() {
		return "/Koo/mate";
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
	
	@GetMapping("/templates/Koo/contact.html")
	public String contact() {
		return "/Koo/contact";
	}
	
}

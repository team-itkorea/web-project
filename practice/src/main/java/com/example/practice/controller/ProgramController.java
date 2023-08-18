package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramController {
	

	
	@GetMapping("/program/leisure")
	public String loadLeisure() {
		return "Kim/programTheme";
	}
	
	@GetMapping("/program/wellness")
	public String loadWellness() {
		return "Kim/programTheme";
	}
	
	@GetMapping("/program/{theme}/detail")
	public String loadProgramDetail(@PathVariable String theme, @RequestParam int code) {
		return "Kim/programDetail";
	}
}

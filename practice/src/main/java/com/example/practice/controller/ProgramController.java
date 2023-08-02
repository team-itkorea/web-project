package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/program")
public class ProgramController {
	
	@GetMapping("/program")
	public String loadProgramMain() {
		return "Kim/program";
	}
	
	@GetMapping("/templates/Kim/program-l.html")
	public String loadLeisure() {
		return "Kim/program-l";
	}
	
	@GetMapping("/templates/Kim/program-w.html")
	public String loadWellness() {
		return "Kim/program-w";
	}
}

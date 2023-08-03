package com.example.practice.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/admin/add")
	public String programAddForm() {
		return "Kim/add-program";
	}
	
	@PostMapping("/admin/add/submit")
	public String programAdd(@ModelAttribute AddProgramReqDto addProgramReqDto) {
		List<String> opts = addProgramReqDto.getOption();
		
		for (String string : opts) {
			addProgramReqDto.setOpt(string);
			try {
				adminService.addprogram(addProgramReqDto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin";
	}
	
}

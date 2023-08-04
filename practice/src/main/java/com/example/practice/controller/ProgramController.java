package com.example.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practice.dto.AddProgramReqDto;
import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.service.ProgramService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramController {
	
	private final ProgramService programService;
	
	@GetMapping("/program")
	public String loadProgramMain() {
		return "Kim/program";
	}
	
//	@GetMapping("/program/leisure")
//	public String loadLeisure() {
//		return "Kim/program-l";
//	}
//	
//	@GetMapping("/program/wellness")
//	public String loadWellness() {
//		return "Kim/program-w";
//	}
	
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
				programService.addprogram(addProgramReqDto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin";
	}	
}

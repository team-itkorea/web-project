package com.example.practice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practice.dto.AddProgramReqDto;
import com.example.practice.dto.CMRespDto;
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
	
	@GetMapping("/program/leisure")
	public String loadLeisure() {
		System.out.println("컨트롤러 실행");
		return "Kim/program-theme";
	}
	
	@GetMapping("/program/wellness")
	public String loadWellness() {
		return "Kim/program-theme";
	}
	
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
		return "redirect:/admin/add";
	}	
	
//	@GetMapping("/program/{theme}")
//	public String getProgramList(@PathVariable String theme) {
//		
//		List<ProgramListRespDto> listdto = null;
//		System.out.println(theme + "확인");
//		try {
//			listdto = programService.getProgramList(theme);
//			System.out.println(listdto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		if(listdto.get(0).getTheme().equals("leisure")) {
//			return "Kim/program-theme";
//		}else if(listdto.get(0).getTheme().equals("wellness")) {
//			return "Kim/program-theme";
//		}else {
//			return "main";
//		}
//	}
	
}

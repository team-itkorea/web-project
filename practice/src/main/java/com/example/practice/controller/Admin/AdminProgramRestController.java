package com.example.practice.controller.Admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.AddProgramReqDto;
import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.program.Program;
import com.example.practice.service.ProgramService;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminProgramRestController {
   
	private final ProgramService programService;
	
	@GetMapping("/api/program/{theme}")
	public ResponseEntity<?> getProgramListByAdmin(@PathVariable String theme) {
		
		List<ProgramListRespDto> listdto = null;
		String str = theme;
		System.out.println("str값 확인: " + str);
		if(str.equals("l")) {
			str = "일상 탐험";
		}
		if(str.equals("w")) {
			str = "웰니스 클럽";
		}
		System.out.println("str값 변경: " + str);
		try {
			listdto = programService.getProgramList(str);
			System.out.println(listdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", listdto));
	}
	
	@PostMapping("/api/newProgram")
	public boolean programAdd(@ModelAttribute AddProgramReqDto addProgramReqDto) {
		boolean status = false;
		List<String> optionList = addProgramReqDto.getOption();
		
		String optionString = String.join(",", optionList);
		
		addProgramReqDto.setOpt(optionString);
		if(addProgramReqDto.getTheme().equals("leisure")) {
			addProgramReqDto.setTheme("일상 탐험");
		}else if(addProgramReqDto.getTheme().equals("wellness")) {
			addProgramReqDto.setTheme("웰니스 클럽");
		}
		
		try {
			status = programService.addprogram(addProgramReqDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}	
	
	@GetMapping("/api/program/modify/{code}")
	public ResponseEntity<?> getProgramListByAdmin(@PathVariable int code) {
		Program program = null;
		
		try {
			program = programService.getProgramDetail(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", program));
	}
	
	@PutMapping("/api/program/update/{code}")
	public boolean programUpdate(@RequestBody AddProgramReqDto addProgramReqDto, @PathVariable int code) {
		boolean status = false;
		List<String> optionList = addProgramReqDto.getOption();
		
		String optionString = String.join(",", optionList);
		
		addProgramReqDto.setOpt(optionString);
		addProgramReqDto.setCode(code);

		try {
			status = programService.updateprogram(addProgramReqDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@DeleteMapping("api/program/delete/{code}")
	public boolean programUpdate(@PathVariable int code) {
		boolean status = false;

		try {
			status = programService.deleteprogram(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
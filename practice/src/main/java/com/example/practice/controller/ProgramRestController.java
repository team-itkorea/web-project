package com.example.practice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.auth.PrincipalDetails;
import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.program.Program;
import com.example.practice.service.ProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProgramRestController {
	
	private final ProgramService programService;
	
	@GetMapping("/api/program/{theme}")
	public ResponseEntity<?> getProgramList(@PathVariable String theme) {
		
		List<ProgramListRespDto> listdto = null;
		System.out.println(theme + "확인");
		try {
			if(theme.equals("leisure")) 
				listdto = programService.getProgramList("일상 탐험");
			else if(theme.equals("wellness")) 
				listdto = programService.getProgramList("웰니스 클럽");
			System.out.println(listdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", listdto));
	}
	
	@GetMapping("/api/program/detail/{code}")
	public ResponseEntity<?> getProgramDetail(@PathVariable int code) {
		Program program = null;
		
		try {
			program = programService.getProgramDetail(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", program));
	}
	
	@PostMapping("/api/program/order/{code}")
	public boolean purchaseProgram(@AuthenticationPrincipal PrincipalDetails principalDetails,@PathVariable int code) {
		boolean status = false;
		Map<String, Integer> map = new HashMap<>();
		
		if(principalDetails != null) {
			map.put("userCode", principalDetails.getUser().getUser_code());
			map.put("programCode", code);
		}else {
			return status;
		}
		status = programService.createOrder(map);
		
		return status;
	}

}

package com.example.practice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.service.ProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProgramRestController {
	
	private final ProgramService programService;
	
	@GetMapping("/program/{theme}")
	public ResponseEntity<?> getProgramList(@PathVariable String theme) {
		
		List<ProgramListRespDto> listdto = null;
		
		try {
			listdto = programService.getProgramList(theme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", listdto));
	}
}

package com.example.practice.controller.Qna;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.auth.PrincipalDetailsService;
import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.QnaRespDto;
import com.example.practice.service.QnaService;
import com.example.practice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnaRestController {
	
	private final QnaService qnaService;
	
	@PostMapping("/writepro")
	public ResponseEntity<?> addQna(@RequestBody QnaRespDto qnaRespDto) {
		boolean status = false;
		System.out.println(qnaRespDto+"들어옴?");
		try {
			qnaService.createQna(qnaRespDto);
			System.out.println(qnaRespDto);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"실패",status));
		}
		System.out.println("확인" + qnaRespDto);
		return ResponseEntity.ok().body(new CMRespDto<>(1,"성공",status));
	}
	
}

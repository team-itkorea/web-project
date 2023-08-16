package com.example.practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.AddNoticeReqDto;
import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.GetNoticeListRespDto;
import com.example.practice.service.NoticeService;
import com.example.practice.user.Notice;
import com.example.practice.user.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeRestController {
	
	private final NoticeService noticeService;
//	private final NoticeRepository noticeRepository;
	
	@PostMapping("/write")
	public ResponseEntity<?> addNotice(@RequestBody AddNoticeReqDto addNoticeReqDto) {
		
		boolean noticeCode = false;
//		System.out.println(addNoticeReqDto + "---1--");
		try {
			noticeCode = noticeService.addNotice(addNoticeReqDto);
//			System.out.println(addNoticeReqDto + "---2---");
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println(addNoticeReqDto+"---3---");
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed", noticeCode));
		}
//		System.out.println(addNoticeReqDto+"---4---");
		return ResponseEntity.ok().body(new CMRespDto<>(1, "complete creation", noticeCode));
	}
	
	@GetMapping("/main/noticelist/{page}")
	public ResponseEntity<?> getBoardList(@PathVariable int page) {
		System.out.println(page + " :3확인");
		List<GetNoticeListRespDto> list = null;
		try {
			list = noticeService.getNoticeList(page);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, page+ "page list fail to load", list));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, page + "page list success to load", list));
	}
	
	@DeleteMapping("/noticeDelete/{noticeCode}")
	public ResponseEntity<?> deletenotice(@PathVariable int noticeCode) {
		boolean status = false;
		try {
			status = noticeService.removeNotice(noticeCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
	}
	
	@GetMapping("/list/findNotice/{noticeCode}")
	public ResponseEntity<?> getNoticeUpdate(@PathVariable int noticeCode) {
		System.out.println(noticeCode + " :1확ㅇ니");
		Notice notice = null;
		try {
			notice = noticeService.getNoticeCode(noticeCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",notice));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1,"success",notice));
	}
	/*
	@PutMapping("/noticeUpdate/{noticeCode}")
	public ResponseEntity<?> updateNotice(@PathVariable String noticeTitle, String ir1, @RequestBody AddNoticeReqDto addNoticeReqDto){
		boolean status = false;
		addNoticeReqDto.setNoticeTitle(noticeTitle);
		addNoticeReqDto.setIr1(ir1);
		try {
			status = noticeService.updateNotice(addNoticeReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "공지수정 실패",status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "공지수정 성공",status));
	}*/
}

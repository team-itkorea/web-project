//package com.example.practice.controller;
//
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.practice.dto.AddNoticeReqDto;
//import com.example.practice.dto.CMRespDto;
//import com.example.practice.dto.GetNoticeListRespDto;
//import com.example.practice.dto.GetNoticeRespDto;
//import com.example.practice.service.NoticeService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class NoticeRestController {
//	
//	private final NoticeService noticeService;
//	
//	@PostMapping("")
//	public ResponseEntity<?> addNotice(AddNoticeReqDto addNoticeReqDto) {
//		
//		int noticeCode = 0;
//		try {
//			noticeCode = noticeService.addNotice(addNoticeReqDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed", noticeCode));
//		}
//		
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "complete creation", noticeCode));
//	}
//	
//	@GetMapping("/{noticeCode}")
//	public ResponseEntity<?> getNotice(@PathVariable int noticeCode) {
//		
//		GetNoticeRespDto getNoticeRespDto = null;
//		try {
//			getNoticeRespDto = noticeService.getNotice(null, noticeCode);
//			if(getNoticeRespDto == null) {
//				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "datebase failed", null));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "datebase error", null));
//		}
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", getNoticeRespDto));
//	}
//	
//	@GetMapping("/list/{page}")
//	public ResponseEntity<?> getNoticeList(@PathVariable int page, @RequestParam String searchFlag, @RequestParam String searchValue) {
//		List<GetNoticeListRespDto> listDto = null;
//		try {
//			listDto = noticeService.getNoticeList(page, searchFlag, searchValue);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", listDto));
//		}
//		
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", listDto));
//	}
//
//}

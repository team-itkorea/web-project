package com.example.practice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.ContactListRespDto;
import com.example.practice.dto.ContactReqDto;
import com.example.practice.service.ContactService;

import lombok.RequiredArgsConstructor;

@RestController
//@RequestMapping("/")
@RequiredArgsConstructor
public class MateContactRestController {
	
	private final ContactService contactService;
	
	@PostMapping("/contact/form")
	public ResponseEntity<?> contactForm(@RequestBody ContactReqDto contactReqDto) {
		contactService.contact(contactReqDto);
//		System.out.println("gd");
		return ResponseEntity.ok(null);
	}
	
//	@GetMapping("/admin/contact/list/{page}")
//	public ResponseEntity<?> adminContact(@PathVariable int page) {
//		List<ContactListRespDto> contactlist = null;
//		try {
//			contactlist = contactService.getContactList(page);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.ok().body(new CMRespDto<>(-1, page+ "page list fail to load", contactlist));
//		}
//		return ResponseEntity.ok().body(new CMRespDto<>(1, page+ "page list success to load", contactlist));
//	}
}

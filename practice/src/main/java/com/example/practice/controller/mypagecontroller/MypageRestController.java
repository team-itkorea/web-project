package com.example.practice.controller.mypagecontroller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.mypage.OrderReqDto;
import com.example.practice.dto.mypage.OrderUpdataReqDto;
import com.example.practice.mypage.Order;
import com.example.practice.mypage.OrderRepository;
import com.example.practice.service.mypage.MypageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageRestController {
	
	private final MypageService mypageService;
	
	//주문 취소
	@PutMapping("/cancel/{orderCode}")
	public ResponseEntity<?> orderCancel(@RequestBody OrderUpdataReqDto orderUpdataReqDto) {
	    boolean status = false;
	    System.out.println(orderUpdataReqDto + "주문취소1");
	    try {
	    	status = mypageService.updateOrder(orderUpdataReqDto);
	    	System.out.println(orderUpdataReqDto + "주문취소2");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "업데이트 실패",status));
		}
		System.out.println(orderUpdataReqDto + "주문취소2");
	    // 여기서 주문 취소 로직 수행
		return ResponseEntity.ok().body(new CMRespDto<>(1, "업데이트 성공",status));
	}

}

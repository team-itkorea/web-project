package com.example.practice.service.mypage;

import java.util.List;

import com.example.practice.dto.mypage.OrderReqDto;
import com.example.practice.dto.mypage.OrderUpdataReqDto;

public interface MypageService {

	public boolean updateOrder(OrderUpdataReqDto orderUpdataReqDto) throws Exception;
}

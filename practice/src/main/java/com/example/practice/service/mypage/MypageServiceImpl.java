package com.example.practice.service.mypage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.dto.mypage.OrderReqDto;
import com.example.practice.dto.mypage.OrderUpdataReqDto;
import com.example.practice.mypage.Order;
import com.example.practice.mypage.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
	
	private final OrderRepository orderRepository;
	
	@Override
	public boolean updateOrder(OrderUpdataReqDto orderUpdataReqDto) throws Exception {
		System.out.println(orderUpdataReqDto + "서비스");
		return orderRepository.updataOrderByOrderCode(orderUpdataReqDto.toEntitOrder()) > 0;
	}

//	@Override
//	public List<OrderReqDto> getAllOrder() throws Exception {
//		List<Order> orders = orderRepository.findAll();
//		List<OrderReqDto> orderReqDtos = new ArrayList<>();
//		
//		for(Order order : orders) {
//			OrderReqDto orderDTO = new OrderReqDto();
//			orderDTO.setOrderCode(order.getOrder_code());
//			orderDTO.setUserCode(order.getUser_code());
//            orderDTO.setProgramCode(order.getProgram_code());
//            orderDTO.setFlagCode(order.getFlag_code());
//            orderDTO.setProgramfileName(order.getProgram_imgUrl_1());
//            orderDTO.setProgramTitle(order.getProgram_title());
//
//            orderReqDtos.add(orderDTO);
//		}
//		return orderReqDtos;
//	}
}

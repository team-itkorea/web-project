package com.example.practice.dto.mypage;

import com.example.practice.mypage.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdataReqDto {

	 private int orderCode;
	 private int flagCode;
	 
	 public Order toEntitOrder() {
		 return Order.builder()
				 .order_code(orderCode)
				 .flag_code(flagCode)
				 .build();
	 }
	 
}

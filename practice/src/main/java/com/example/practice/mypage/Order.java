package com.example.practice.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
	
	private int order_code;
	private int user_code;
	private int program_code;
	private int flag_code;
	private String program_title;
	private String program_imgUrl_1;
	
	

}

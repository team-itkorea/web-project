package com.example.practice.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Heart {
	private int heart_code;
	private int user_code;
	private int program_code;
	private String program_title;
	private String program_imgUrl_1;
}

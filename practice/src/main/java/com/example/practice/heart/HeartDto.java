package com.example.practice.heart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartDto {
	private int usercode;
	private int programcode;
	
//	public Heart toEntity() {
//		return Heart.builder()
//				.user_email(email)
//				.program_code(code).build();
//	}
}

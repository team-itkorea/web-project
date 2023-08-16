package com.example.practice.heart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Heart {
	private int heart_code;
	private int user_code;
	private int program_code;
}

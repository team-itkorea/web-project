package com.example.practice.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Program {
	private int program_code;
	private String program_theme;
	private String program_title;
	private String program_price;
	private String program_info;
	private String program_place;
	private String program_schedule;
	private String program_time;
	private String program_participants;
	
	private String program_option;
	
	private String program_like;
	private String program_imgUrl_1;
	private String program_imgUrl_2;
}

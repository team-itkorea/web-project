package com.example.practice.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.practice.program.Program;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProgramReqDto {
	private String theme;
	private String title;
	private String price;
	private String info;
	private String place;
	private String schedule;
	private String time;
	
	private String participants;
	
	private List<String> option;
	
	private int heart;
	private MultipartFile imgUrl_1;
	private MultipartFile imgUrl_2;
	
	@JsonIgnore
	private String opt;
	@JsonIgnore
	private int code;
	
	public Program toEntity() {
		return Program.builder()
				.program_theme(theme)
				.program_title(title)
				.program_price(price)
				.program_info(info)
				.program_place(place)
				.program_schedule(schedule)
				.program_time(time)
				.program_participants(participants)
				.program_option(opt)
				.program_heart(heart).build();
	}
	
	public Program updateEntity() {
		return Program.builder()
				.program_code(code)
				.program_title(title)
				.program_price(price)
				.program_info(info)
				.program_place(place)
				.program_schedule(schedule)
				.program_time(time)
				.program_participants(participants)
				.program_option(opt)
				.program_heart(heart).build();
	}
	
	
}

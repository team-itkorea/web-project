package com.example.practice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgramListRespDto {
	private String theme;
	private String title;
	private String fileName;
	private String uploadDate;
}

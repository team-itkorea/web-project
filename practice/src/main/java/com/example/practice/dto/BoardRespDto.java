package com.example.practice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardRespDto {
	private String boardTitle;
	private String boardContent;
	private LocalDateTime createDate;
}

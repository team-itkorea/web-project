package com.example.practice.dto;

import javax.validation.constraints.NotBlank;

import com.example.practice.user.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardReqDto {
	
	@NotBlank
	private String boardTitle;
	@NotBlank
	private String boardContent;
	
	
	public Board toEntityBoard() {
		return Board.builder()
				.title(boardTitle)
				.content(boardContent)
				.build();
	}
}

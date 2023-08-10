package com.example.practice.user;


import java.time.LocalDateTime;


import com.example.practice.dto.BoardRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int board_code;
	private String title;
	private String content;
	private int user_code;
	private LocalDateTime create_date;
	
	public BoardRespDto toBoardEntity() {
		return BoardRespDto.builder()
					.boardCode(board_code)
					.boardTitle(title)
					.boardContent(content)
					.createDate(create_date)
					.build();
	}
	
}

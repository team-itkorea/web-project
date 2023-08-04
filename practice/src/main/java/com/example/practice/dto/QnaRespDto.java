package com.example.practice.dto;

import com.example.practice.user.Qna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaRespDto {
	
	private String QnaTitle;
	private String QnaContent;
	
	public Qna toEntitQna() {
		return Qna.builder()
					.qna_title(QnaTitle)
					.qna_content(QnaContent)
					.build();
	}
	

}

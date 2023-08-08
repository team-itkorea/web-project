package com.example.practice.dto;

import com.example.practice.user.Notice;

import lombok.Data;

@Data
public class AddNoticeReqDto {
	private String noticeTitle;
	private int userCode;
	private String ir1;
	
	public Notice toEntity() {
		return Notice.builder()
				.notice_title(noticeTitle)
				.user_code(userCode)
				.notice_content(ir1)
				.build();
	}
}

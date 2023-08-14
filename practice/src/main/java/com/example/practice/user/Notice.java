package com.example.practice.user;

import java.time.LocalDateTime;

import com.example.practice.dto.GetNoticeListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notice {

	private int notice_code; // 번호
	private String notice_title; // 공지 제목
	private int user_code; // 유저정보
	private String user_name; //유저 이름
	private String notice_content; // 내용
	private LocalDateTime create_date;
	
	/*
	 * .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
	 */
	
	public GetNoticeListRespDto toListDto() {
		System.out.println("체크"+create_date);
		return GetNoticeListRespDto.builder()
				.noticeCode(notice_code)
				.noticeTitle(notice_title)
				.noticecontent(notice_content)
				.usercode(user_code)
				.username(user_name)
				.createDate(create_date)
				.build();
	}
}

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
	private String user_name; // 유저 이름
	private String notice_content; // 내용
	private int notice_count; // 조회
	
	private int total_notice_count; // 총 조회?
	
	public GetNoticeListRespDto toListDto() {
		return GetNoticeListRespDto.builder()
				.noticeCode(notice_code)
				.noticeTitle(notice_title)
				.username(user_name)
				.noticeCount(notice_count)
				.totalNoticeCount(total_notice_count)
				.build();
	}
}

package com.example.practice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetNoticeListRespDto {

	private int noticeCode;
	private String noticeTitle;
	private String username;
	private String createDate;
	private int noticeCount;
	private int totalNoticeCount;
}

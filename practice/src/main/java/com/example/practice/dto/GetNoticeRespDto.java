package com.example.practice.dto;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetNoticeRespDto {
	
	private int noticeCode;
	private String noticeTitle;
	private int userCode;
	private String userName;
	private String createDate;
	private int noticeCount;
	private String noticeContent;
}

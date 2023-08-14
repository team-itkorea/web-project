package com.example.practice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetNoticeListRespDto {

	private int noticeCode;
	private String noticeTitle;
	private String noticecontent;
	private int usercode;
	private String username;
	private LocalDateTime createDate;
}

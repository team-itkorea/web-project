package com.example.practice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContactListRespDto {
	private int contactCode;
	private String contactCategory;
	private String etc;					//기타
	private String nonUsername;	//이름
	private String nonUserphone;	//연락처
	private String nonUseremail;	//이메일
	private String contactContent;	//내용
	private String contactAagree;	//동의,미동의
	private LocalDateTime createDate;
}

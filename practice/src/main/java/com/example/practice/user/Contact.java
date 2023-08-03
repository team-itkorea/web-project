package com.example.practice.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
	private int contact_code;
	private String contact_category;	//유형
	private String etc;
	private String non_username;	//이름
	private String non_userphone;	//연락처
	private String non_useremail;	//이메일
	private String contact_content;	//내용
	private String contact_agree;	//동의,미동의
}

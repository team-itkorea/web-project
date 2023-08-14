package com.example.practice.user;

import java.time.LocalDateTime;

import com.example.practice.dto.ContactListRespDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
	private int contact_code;
	private String contact_category;	//유형
	private String etc;					//기타
	private String non_username;	//이름
	private String non_userphone;	//연락처
	private String non_useremail;	//이메일
	private String contact_content;	//내용
	private String contact_agree;	//동의,미동의
	private LocalDateTime create_date;
	
	public ContactListRespDto toContactListDto() {
		return ContactListRespDto.builder()
				.contactCode(contact_code)
				.contactCategory(contact_category)
				.etc(etc)
				.nonUsername(non_username)
				.nonUserphone(non_userphone)
				.nonUseremail(non_useremail)
				.contactContent(contact_content)
				.contactAagree(contact_agree)
				.createDate(create_date)
				.build();
	}
}

package com.example.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.practice.user.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactReqDto {
	
	private String etc;
	
	@NotBlank
	private String contact_category;	//유형
	@NotBlank
	@Pattern(regexp = "^[가-힇]*$", message = "한글만 입력 가능합니다.")
	private String name;	//이름
	@NotBlank
	private String userphone;	//연락처
	@NotBlank
	@Email
	private String useremail;	//이메일
	@NotBlank
	private String contact_content;	//내용
	@NotBlank
	private String contact_agree;
	
	public Contact toEntity() {
		return Contact.builder()
				.contact_category(contact_category)
				.etc(etc)
				.non_username(name)
				.non_userphone(userphone)
				.non_useremail(useremail)
				.contact_content(contact_content)
				.contact_agree(contact_agree)
				.build();
	}
}

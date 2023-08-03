package com.example.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.practice.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserReqDto {

	private Integer user_code;
	private String user_name;
	private String user_address;
	private String user_phone;
	private Integer user_gender;
	private String user_birth;
	private String user_prfile_img;
	
	public User toEntiUser() {
		return User.builder()
				.user_code(user_code)
				.user_name(user_name)
				.user_address(user_address)
				.user_phone(user_phone)
				.user_gender(user_gender)
				.user_birth(user_birth)
				.user_profile_img(user_prfile_img)
				.build();
	}
}

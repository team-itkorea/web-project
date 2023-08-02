package com.example.practice.dto;

import com.example.practice.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupReqDto {
	private String name;
	private String email;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.user_name(name)
				.user_email(email)
				.user_password(password)
				.user_role("ROLE_USER")
				.build();
	}
}

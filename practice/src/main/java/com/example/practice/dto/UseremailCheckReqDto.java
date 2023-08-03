package com.example.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UseremailCheckReqDto {

	@NotBlank
	@Email
	private String userEmail;
}

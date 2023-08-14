package com.example.practice.dto;

import lombok.Data;

@Data
public class ResetPassword {
	
	private String userEmail;
	private String newPassword;
}

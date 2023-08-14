package com.example.practice.user;

import java.time.LocalDateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// DB의 열값이랑 이름 똑같이
public class User {

	private int user_code;
	private String user_name;
	private String user_email;
	private String oauth2_id;
	private String user_password;
	private String user_address;
	private String user_phone;
	private int user_gender;
	private String user_birth;
	private String user_profile_img;
	private String user_role;
	private String user_provider;
	private LocalDateTime create_date;
}

package com.example.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.practice.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupReqDto {
	@NotBlank
	@Pattern(regexp = "^[가-힇]*$", message = "한글만 입력 가능합니다." )
	private String userName;
	@NotBlank
	@Email
	private String userEmail;
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d_~!@#$%^&*_+=]{8,16}$", message = "영문자, 특수문자, 숫자를 모두 포함해야 합니다.")
	private String userPassword;
	@NotBlank
	private String userAddress;
	@NotBlank
	private String userPhone;
	@NotNull
	@Min(0)
	@Max(1)
	private Integer userGender;
	@NotBlank
	private String userBirth;
	private String userPrfileImg;
	private String userRole;
	
	public User toEntity() {
		return User.builder()
				.user_name(userName)
				.user_email(userEmail)
				.user_password(new BCryptPasswordEncoder().encode(userPassword))
				.user_address(userAddress)
				.user_phone(userPhone)
				.user_gender(userGender)
				.user_birth(userBirth)
				.user_profile_img(userPrfileImg)
				.user_role("ROLE_USER")
				.build();
	}
}

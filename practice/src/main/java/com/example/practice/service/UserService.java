package com.example.practice.service;

import com.example.practice.dto.ResetPassword;
import com.example.practice.dto.SignupReqDto;
import com.example.practice.dto.UpdateUserReqDto;
import com.example.practice.dto.UseremailCheckReqDto;
import com.example.practice.user.User;

public interface UserService {
	public boolean signup(SignupReqDto signupReqDto);
	
	public boolean getProgramList(String theme);
	
	public boolean checkUseremail(UseremailCheckReqDto useremailCheckReqDto ) throws Exception; 
	
	public boolean updateUser(UpdateUserReqDto updateUserReqDto ) throws Exception; 
	
	public boolean removeUser (int userCode) throws Exception;
	
	public boolean resetPassword(ResetPassword resetPassword) throws Exception;

	public User getUserByCode(int userCode) throws Exception;
}

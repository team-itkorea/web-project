package com.example.practice.service;

import com.example.practice.dto.UpdateUserReqDto;
import com.example.practice.dto.UseremailCheckReqDto;

public interface UserService {
	public boolean signup() throws Exception;
	public boolean checkUseremail(UseremailCheckReqDto useremailCheckReqDto) throws Exception;
	
	public boolean updateUser(UpdateUserReqDto updateUserReqDto) throws Exception;
	
	public boolean removeUser(int userCode) throws Exception;
}

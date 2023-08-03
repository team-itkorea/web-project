package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.SignupReqDto;
import com.example.practice.dto.UpdateUserReqDto;
import com.example.practice.dto.UseremailCheckReqDto;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public boolean signup(SignupReqDto signupReqDto) {
		return false;
	}

	@Override
	public boolean getProgramList(String theme) {
		return false;
	}
	@Override
	public boolean checkUseremail(UseremailCheckReqDto useremailCheckReqDto) throws Exception {
		
		return userRepository.findByUseremail(useremailCheckReqDto.getUserEmail()) == null;
	}

	@Override
	public boolean updateUser(UpdateUserReqDto updateUserReqDto) throws Exception {
		return userRepository.updataUserByUserCode(updateUserReqDto.toEntiUser()) > 0;
	}
	
	@Override
	public boolean removeUser(int userCode) throws Exception {
		return userRepository.remove(userCode) > 0;
	}
}

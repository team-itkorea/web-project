package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.SignupReqDto;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public boolean signup(SignupReqDto signupReqDto) {
		User userEntity = signupReqDto.toEntity();
		return userRepository.addUser(userEntity) > 0;
	}

}

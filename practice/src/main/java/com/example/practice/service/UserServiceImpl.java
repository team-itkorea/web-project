package com.example.practice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.practice.dto.ResetPassword;
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
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	
	@Override
	public boolean resetPassword(ResetPassword resetPassword) throws Exception {
		String userEmail = resetPassword.getUserEmail();
		String newPassword = resetPassword.getNewPassword();
		
		User user = userRepository.findByUseremail(userEmail);
		if(user == null) {
			return false;
		}
		
		if(!isValidPassword(newPassword)) {
			return false;
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(newPassword);
		user.setUser_password(encodePassword);
		userRepository.updateUserPassword(user);
		
		return true;
	}
	private boolean isValidPassword(String password) {
		if (password.length() < 6 || password.length() > 16) {
	        return false;
	    }
		return true;
	}
	
	@Override
	public User getUserByCode(int userCode) throws Exception {
		return userRepository.findByUserCode(userCode);
	}
}

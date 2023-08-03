package com.example.practice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.practice.dto.SignupReqDto;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IOC되어있는 loadUserByUsername 함수가 실행됨
// 시큐리티 session <= Authentication <= UserDetails
// DB에서 사용자 정보를 가져와주는 작업

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		User userEntity = null;
		try {
	         userEntity = userRepository.findByUseremail(userEmail);
	    } catch (Exception e) {
	    	e.printStackTrace();
	       throw new UsernameNotFoundException("사용자 조회 중 오류 발생: " + userEmail);
	    }
		if (userEntity == null) {
			throw new UsernameNotFoundException("사용자 조회 중 오류 발생: " + userEmail);
		}
		 
	    
//		User userEntity = null;
//		try {
//			userEntity = userRepository.findByUseremail(userEmail);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UsernameNotFoundException(userEmail);
//		}
//		
//		if(userEntity == null) {
//			throw new UsernameNotFoundException(userEmail + "사용자이름을 사용할 수 없습니다.");
//		}	
//		
		return new PrincipalDetails(userEntity);
	}
	
	public boolean addUser(SignupReqDto signupReqDto) throws Exception {
		return userRepository.addUser(signupReqDto.toEntity()) > 0;
	}
}

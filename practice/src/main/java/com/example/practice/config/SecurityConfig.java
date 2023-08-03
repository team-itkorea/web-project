package com.example.practice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.practice.auth.AuthFailureHandler;
import com.example.practice.dto.BoardReqDto;
import com.example.practice.service.BoardService;

@Configuration		// Spring의 설정 클래스로 지정
@EnableWebSecurity	// Spring Security를 활성화
public class SecurityConfig {
	
	   @Bean
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	       return http.csrf().disable()
	    		   .authorizeRequests()											// antMatchers 기능 이용(설정 세팅)
	               .antMatchers("/user/**").authenticated()						// 특정 URL 접근 시 인증이 필요한 URI 설정
	               .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")	// ADMIN 권한을 가진 사용자만 해당 URL에 접근 가능
	               .anyRequest().permitAll()									// 그 외 모든 요청은 인증 없이 접근 가능

	               .and()
	               .formLogin()													// 로그인 형태
	               .loginPage("/loginForm")										// 인가되지 않은 사용자에게 보여줄 페이지
	               
	               .loginProcessingUrl("/login")							    // 시큐리티가 낚아챈다(컨트롤러에 안 만들어도 됨)
	               .defaultSuccessUrl("/")										// 로그인 성공 시 메인 페이지로
	               .failureHandler(new AuthFailureHandler())
	               .and().build();
	   }

	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public BoardService boardService() {
	    	return new BoardService() {
				
				@Override
				public boolean createBoard(BoardReqDto boardReqDto) throws Exception {
					// TODO Auto-generated method stub
					return false;
				}
			};
	    }
}

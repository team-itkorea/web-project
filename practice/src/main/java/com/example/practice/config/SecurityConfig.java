package com.example.practice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.practice.auth.AuthFailureHandler;
import com.example.practice.auth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration		// Spring의 설정 클래스로 지정
@EnableWebSecurity	// Spring Security를 활성화
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
//	   @Bean
//	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	       return http.csrf().disable()
//	    		   .authorizeRequests()											// antMatchers 기능 이용(설정 세팅)
//	               .antMatchers("/user/**").authenticated()						// 특정 URL 접근 시 인증이 필요한 URI 설정
//	               .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")	// ADMIN 권한을 가진 사용자만 해당 URL에 접근 가능
//	               .anyRequest().permitAll()									// 그 외 모든 요청은 인증 없이 접근 가능
//
//	               .and()
//	               .formLogin()													// 로그인 형태
//	               .loginPage("/auth/signin")		
//	               .loginProcessingUrl("/auth/signin")							    // 시큐리티가 낚아챈다(컨트롤러에 안 만들어도 됨)
//	               .defaultSuccessUrl("/")										// 로그인 성공 시 메인 페이지로
//	               .failureHandler(new AuthFailureHandler())
//	               .and().build();
//	   }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
	        http.authorizeRequests()
	        .antMatchers("/user/**").authenticated()
//	        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
	        .anyRequest().permitAll()
	        
	        .and()
	        .formLogin()
	        .loginPage("/auth/signin")
	        .loginProcessingUrl("/auth/signin")
	        .defaultSuccessUrl("/")
	        .failureHandler(new AuthFailureHandler());
	        
//	        .and()
//			.oauth2Login()
//			.userInfoEndpoint()
//			.userService(principalOauth2UserService)
//			.and()
//			.defaultSuccessUrl("/");
	        http.headers().frameOptions().sameOrigin();
	}
	

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}

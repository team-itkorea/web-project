package com.example.practice.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public int addUser(User user) throws Exception;

	public User findByUseremail(String userEmail) throws Exception; 
	
	public int updataUserByUserCode(User user) throws Exception;
	
	public int remove(int userCode) throws Exception;
	
	public User findOAuth2UserByUseremail(String oauth2_id) throws Exception;
	
	public User findByNameAndUserPhone(String userName, String userPhone) throws Exception;
	
	public int updateUserPassword(User user) throws Exception;
	
	public List<User> findAll() throws Exception;
	
	public User findByUserCode(int userCode) throws Exception;
}

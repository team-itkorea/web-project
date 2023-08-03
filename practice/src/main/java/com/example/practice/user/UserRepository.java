package com.example.practice.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int addUser(User user) throws Exception;

	public User findByUseremail(String userEmail) throws Exception; 
	
	public int updataUserByUserCode(User user) throws Exception;
	
	public int remove(int userCode) throws Exception;
}

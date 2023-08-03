package com.example.practice.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int addUser(User user);

	public User findByUsername(String username); 
}

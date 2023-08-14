package com.example.practice.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactRepository {
	public int addContact(Contact contact);

}

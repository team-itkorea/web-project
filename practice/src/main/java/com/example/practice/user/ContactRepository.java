package com.example.practice.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactRepository {
	public int addContact(Contact contact);

	public List<Contact> getContactList(int index) throws Exception;
	
	public List<Contact> getContactListLis(String contactCategory) throws Exception;
	
	public int remove(int contactCode) throws Exception;
	
	public List<Contact> getCheckContact(int contactCode) throws Exception;
}

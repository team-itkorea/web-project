package com.example.practice.service;

import java.util.List;

import com.example.practice.dto.ContactListRespDto;
import com.example.practice.dto.ContactReqDto;

public interface ContactService {
	
	public boolean contact(ContactReqDto contactReqDto);
	
	public List<ContactListRespDto> getContactList(int page) throws Exception;
	
	public boolean removeContact(int contactCode) throws Exception;
	
	public List<ContactListRespDto> getCheckContact(int contactCode) throws Exception;
}

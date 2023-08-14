package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.ContactReqDto;
import com.example.practice.user.Contact;
import com.example.practice.user.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService{
	
	private final ContactRepository contactRepository;

	@Override
	public boolean contact(ContactReqDto contactReqDto) {
		System.out.println(contactReqDto);
		System.out.println(contactReqDto.getName());
		Contact contactEntity = contactReqDto.toEntity();
		return contactRepository.addContact(contactEntity) > 0;
	}

}

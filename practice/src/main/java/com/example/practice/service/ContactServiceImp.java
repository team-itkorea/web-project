package com.example.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.dto.ContactListRespDto;
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

	@Override
	public List<ContactListRespDto> getContactList(int page) throws Exception {
		System.out.println(page + " :1번 확인");
		int index = (page - 1) * 10;
		List<Contact> contactlist = contactRepository.getContactList(index);
		System.out.println(contactlist + " :2번 확인");
		return createContactListRespDtos(contactlist);
	}
	
	private List<ContactListRespDto> createContactListRespDtos(List<Contact> contactlist) {
		List<ContactListRespDto> contactListRespDtos = new ArrayList<ContactListRespDto>();
		contactlist.forEach(contact -> {
			contactListRespDtos.add(contact.toContactListDto());
		});
		return contactListRespDtos;
	}


	@Override
	public boolean removeContact(int contactCode) throws Exception {
		return contactRepository.remove(contactCode) > 0;
	}

	@Override
	public List<ContactListRespDto> getCheckContact(int contactCode) throws Exception {
		List<Contact> checkContact = contactRepository.getCheckContact(contactCode);
		System.err.println(checkContact + " :1 체크");
		return createContactListRespDtos(checkContact);
	}

}

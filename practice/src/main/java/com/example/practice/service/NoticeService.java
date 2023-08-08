package com.example.practice.service;

import java.util.List;

import com.example.practice.dto.AddNoticeReqDto;
import com.example.practice.dto.GetNoticeListRespDto;
import com.example.practice.dto.GetNoticeRespDto;
import com.example.practice.user.Notice;


public interface NoticeService {
	// throws Exception 예외를 보냄 (뒤로 미루는 느낌)
	public boolean addNotice(AddNoticeReqDto addNoticeReqDto) throws Exception;
	
	public GetNoticeRespDto getNotice(String flag, int noticeCode) throws Exception;
	
	public List<GetNoticeListRespDto> getNoticeList(int page, String searchFlag, String searchValue) throws Exception;
}

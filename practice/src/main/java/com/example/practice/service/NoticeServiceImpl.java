package com.example.practice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.practice.dto.AddNoticeReqDto;
import com.example.practice.dto.GetNoticeListRespDto;
import com.example.practice.user.Notice;
import com.example.practice.user.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;

	@Override
	public boolean addNotice(AddNoticeReqDto addNoticeReqDto) throws Exception {
		System.out.println(addNoticeReqDto + "확인");
		return noticeRepository.saveNotice(addNoticeReqDto.toEntity()) > 0;
	}

	@Override
	public List<GetNoticeListRespDto> getNoticeList(int page) throws Exception {
		System.out.println( page + " :1확인");
		int index = (page - 1) * 10;
		List<Notice> noticelist = noticeRepository.getNoticeList(index);
		System.out.println(noticelist + " :2확인");
		return createBoardListRespDtos(noticelist);
	}
	
	private List<GetNoticeListRespDto> createBoardListRespDtos(List<Notice> noticelist) {
		List<GetNoticeListRespDto> noticeListRespDtos = new ArrayList<GetNoticeListRespDto>();
		noticelist.forEach(notice -> {
			noticeListRespDtos.add(notice.toListDto());
		});
		return noticeListRespDtos;
	}

	@Override
	public boolean removeNotice(int noticeCode) throws Exception {
		return noticeRepository.remove(noticeCode) > 0;
	}

	@Override
	public Notice getNoticeCode(int noticeCode) throws Exception {
		System.out.println(noticeCode + " :2확인");
		return noticeRepository.findNoticeCode(noticeCode);
	}


	
}

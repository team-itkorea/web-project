package com.example.practice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.practice.dto.AddNoticeReqDto;
import com.example.practice.dto.GetNoticeListRespDto;
import com.example.practice.dto.GetNoticeRespDto;
import com.example.practice.user.Notice;
import com.example.practice.user.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;

	@Override
	public int addNotice(AddNoticeReqDto addNoticeReqDto) throws Exception {
		
		Notice notice = null;
		
		notice = Notice.builder()
				.notice_title(addNoticeReqDto.getNoticeTitle())
				.user_code(addNoticeReqDto.getUserCode())
				.notice_content(addNoticeReqDto.getIr1())
				.build();
		
		noticeRepository.saveNotice(notice);
		
	return notice.getNotice_code();
	}

	@Override
	public GetNoticeRespDto getNotice(String flag, int noticeCode) throws Exception {
		GetNoticeRespDto getNoticeRespDto = null;
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("flag", flag);
		reqMap.put("notice_code", noticeCode);
		
		List<Notice> notices = noticeRepository.getNotice(reqMap);
		if(!notices.isEmpty()) {
	        Notice firstNotice = notices.get(0);
	        getNoticeRespDto = GetNoticeRespDto.builder()
	                .noticeCode(firstNotice.getNotice_code())
	                .noticeTitle(firstNotice.getNotice_title())
	                .userCode(firstNotice.getUser_code())
	                .userName(firstNotice.getUser_name())
	                .noticeCount(firstNotice.getNotice_count())
	                .noticeContent(firstNotice.getNotice_content())
	                .build();
		}
		return getNoticeRespDto;
	}

	@Override
	public List<GetNoticeListRespDto> getNoticeList(int page, String searchFlag, String searchValue) throws Exception {

		int index = (page - 1) * 10;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index);
		map.put("search_flag", searchFlag);
		map.put("search_value", searchValue == null ? "" : searchValue);
		
		List<GetNoticeListRespDto> list = new ArrayList<GetNoticeListRespDto>();
		
		noticeRepository.getNoticeList(map).forEach(notice -> {
			list.add(notice.toListDto());
		});		
		return list;
	}

}

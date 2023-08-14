package com.example.practice.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeRepository {
	
	public int saveNotice(Notice notice) throws Exception;
	
	public List<Notice> getNoticeList(int index) throws Exception;
	
	public int remove(int noticeCode) throws Exception;
	
	public Notice findNoticeCode(int noticeCode) throws Exception;
}

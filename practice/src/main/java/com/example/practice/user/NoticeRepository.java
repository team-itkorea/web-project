package com.example.practice.user;

import java.util.List;
import java.util.Map;

public interface NoticeRepository {
	
	public int saveNotice(Notice notice) throws Exception;
	
	public List<Notice> getNotice(Map<String, Object> map) throws Exception;
	
	public List<Notice> getNoticeList(Map<String, Object> map) throws Exception;
}

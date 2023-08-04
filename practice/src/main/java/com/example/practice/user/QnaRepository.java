package com.example.practice.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaRepository {
	
	public int save(Qna qna) throws Exception;

}

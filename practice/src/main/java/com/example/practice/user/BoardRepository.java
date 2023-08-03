package com.example.practice.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.dto.BoardRespDto;

@Mapper
public interface BoardRepository {
	
	public int save(Board board) throws Exception;
	
//	public List<Board> getBoardList(Map<String, Object> map) throws Exception;
	
}
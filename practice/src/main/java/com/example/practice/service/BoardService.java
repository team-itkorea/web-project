package com.example.practice.service;

import java.util.List;


import com.example.practice.dto.BoardReqDto;
import com.example.practice.dto.BoardRespDto;
import com.example.practice.user.Board;
import com.example.practice.user.BoardRepository;


public interface BoardService {
	
	public boolean createBoard(BoardReqDto boardReqDto) throws Exception; 
	
	
	public List<BoardRespDto> getBoardList(int page) throws Exception; 

}

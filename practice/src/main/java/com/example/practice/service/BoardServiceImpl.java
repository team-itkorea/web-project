package com.example.practice.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.practice.dto.BoardReqDto;
import com.example.practice.dto.BoardRespDto;
import com.example.practice.user.Board;
import com.example.practice.user.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public boolean createBoard(BoardReqDto boardReqDto) throws Exception {
		System.out.println(boardReqDto + "서비스 확인");
		
		return boardRepository.save(boardReqDto.toEntityBoard()) > 0 ;
	}

	@Override
	public List<BoardRespDto> getBoardList(int page) throws Exception {
		System.out.println( page + "확인");
		int index = (page - 1) * 10;
		List<Board> boardlist = boardRepository.getBoardList(index);
		System.out.println(boardlist + "확인");
		return createBoardListRespDtos(boardlist);
	}
	
	private List<BoardRespDto> createBoardListRespDtos(List<Board> boardList) {
		List<BoardRespDto> boardListRespDtos = new ArrayList<BoardRespDto>();
		boardList.forEach(board -> {
			boardListRespDtos.add(board.toBoardEntity());
		});
		return boardListRespDtos;
	}
	
}

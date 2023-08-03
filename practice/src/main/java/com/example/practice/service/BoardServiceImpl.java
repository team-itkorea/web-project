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
	
//	@Override
//	public List<BoardRespDto> getBoardList(String type, int page) throws Exception  {
//		List<Board> boardlist = boardRepository.getBoardList(createGetBoardListMap(type, page));
//		return createBoardListRespDtos(boardlist);
//	}
	
	
	
//	private Map<String, Object> createGetBoardListMap(String type, int Page) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("type", type);
//		map.put("index", Page);
//		return map;
//	}
	
	
	
//	private List<BoardRespDto> createBoardListRespDtos(List<Board> boardList) {
//		List<BoardRespDto> boardListRespDtos = new ArrayList<BoardRespDto>();
//		boardList.forEach(board -> {
//			boardListRespDtos.add(board.toBoardEntity());
//		});
//		return boardListRespDtos;
//	}
	
}

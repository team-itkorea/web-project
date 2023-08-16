package com.example.practice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.BoardReqDto;
import com.example.practice.dto.BoardRespDto;
import com.example.practice.dto.CMRespDto;
import com.example.practice.service.BoardService;
import com.example.practice.service.BoardServiceImpl;
import com.example.practice.user.Board;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BoardController {
	
	
	 private final BoardService boardService;

	    @PostMapping("/board/writepro")
	    public ResponseEntity<?> boardWritePro(@RequestBody BoardReqDto boardReqDto) {
	    	boolean status = false;
	    	try {
	    		status = boardService.createBoard(boardReqDto);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.ok().body(new CMRespDto<>(-1, "실패", status));
			}
	    	return ResponseEntity.ok().body(new CMRespDto<>(1, "성공", status));
	    }
	    
		@GetMapping("/board/noticelist/{page}")
		public ResponseEntity<?> getBoardList(@PathVariable int page) {
			System.out.println("page" + page);
			List<BoardRespDto> list = null;
			try {
				list = boardService.getBoardList(page);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.ok().body(new CMRespDto<>(-1, page+ "page list fail to load", list));
			}
			return ResponseEntity.ok().body(new CMRespDto<>(1, page + "page list success to load", list));
		}
		
	
	
	
	
	
	
}
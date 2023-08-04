package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.QnaRespDto;
import com.example.practice.user.QnaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {
	
	private final QnaRepository qnaRepository;

	@Override
	public boolean createQna(QnaRespDto qnaRespDto) throws Exception {
		return qnaRepository.save(qnaRespDto.toEntitQna()) > 0;
	}
}

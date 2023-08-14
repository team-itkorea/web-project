package com.example.practice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.practice.heart.Heart;
import com.example.practice.heart.HeartDto;
import com.example.practice.heart.HeartRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {

	private final HeartRepository heartRepository;

	@Override
	public Heart findHeart(HeartDto heartDto) {
		Map<String, Integer> codes = new HashMap<>();
		codes.put("user_code", heartDto.getUsercode());
		codes.put("program_code", heartDto.getProgramcode());

		return heartRepository.findHeart(codes);
	}

	@Override
	public boolean createHeart(HeartDto heartDto) {
		Map<String, Integer> codes = new HashMap<>();
		codes.put("user_code", heartDto.getUsercode());
		codes.put("program_code", heartDto.getProgramcode());
		
		return heartRepository.createHeart(codes);
	}

	@Override
	public boolean cancelHeart(HeartDto heartDto) {
		Map<String, Integer> codes = new HashMap<>();
		codes.put("user_code", heartDto.getUsercode());
		codes.put("program_code", heartDto.getProgramcode());
		
		return heartRepository.cancelHeart(codes);
	}
}

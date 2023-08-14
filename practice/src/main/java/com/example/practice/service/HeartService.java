package com.example.practice.service;

import com.example.practice.heart.Heart;
import com.example.practice.heart.HeartDto;

public interface HeartService {
	public Heart findHeart(HeartDto heartDto);
	
	public boolean createHeart(HeartDto heartDto);
	
	public boolean cancelHeart(HeartDto heartDto);
}

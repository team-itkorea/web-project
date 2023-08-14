package com.example.practice.heart;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartRepository {
	public Heart findHeart(Map<String, Integer> codes);
	public boolean createHeart(Map<String, Integer> codes);
	public boolean cancelHeart(Map<String, Integer> codes);
}

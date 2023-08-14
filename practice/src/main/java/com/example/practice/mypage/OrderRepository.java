package com.example.practice.mypage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.practice.user.User;

@Mapper
public interface OrderRepository {
	
	public List<Order> findAll(int user_code, int flagNum) ;

	public List<Order> findOrdersByUserAndFlagNum(int user_code	, int flagNum);
	
	public List<Heart> findHeart(int user_code);
	
	public int updataOrderByOrderCode(Order order) throws Exception;

}

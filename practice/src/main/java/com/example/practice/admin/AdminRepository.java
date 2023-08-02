package com.example.practice.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
	public boolean addProgram(Program program) throws Exception;
}

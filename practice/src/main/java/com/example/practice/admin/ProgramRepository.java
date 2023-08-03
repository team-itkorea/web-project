package com.example.practice.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProgramRepository {
	public List<Program> GetProgramList(String theme);
}

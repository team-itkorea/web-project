package com.example.practice.program;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProgramRepository {
	public List<Program> GetProgramList(String theme) throws Exception;
	
	public boolean addProgram(Program program) throws Exception;
}

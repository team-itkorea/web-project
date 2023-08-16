package com.example.practice.program;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProgramRepository {
	public List<Program> GetProgramList(String theme) throws Exception;
	
	public boolean addProgram(Program program) throws Exception;
	
	public boolean updateProgram(Program program) throws Exception;
	
	public boolean deleteProgram(int code) throws Exception;
	
	public Program GetProgramDetail(int code) throws Exception;
	
	public boolean addHeart(int code) throws Exception;
	
	public boolean subHeart(int code) throws Exception;
	
	public boolean createOrder(Map<String, Integer> codes);
	

}

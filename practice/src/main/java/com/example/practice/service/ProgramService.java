package com.example.practice.service;

import java.util.List;

import com.example.practice.dto.AddProgramReqDto;
import com.example.practice.dto.ProgramListRespDto;

public interface ProgramService {
	public boolean addprogram(AddProgramReqDto addProgramReqDto) throws Exception;
	
	public List<ProgramListRespDto> getProgramList(String theme) throws Exception;
}

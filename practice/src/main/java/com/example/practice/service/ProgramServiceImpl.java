package com.example.practice.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.practice.dto.AddProgramReqDto;
import com.example.practice.dto.ProgramListRespDto;
import com.example.practice.program.Program;
import com.example.practice.program.ProgramRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

	@Value("${file.path}")
	private String filepath;
	
	private final ProgramRepository programRepository;
	
	Predicate<String> predicate = (filename) -> !filename.isBlank();
	
	@Override
	public boolean addprogram(AddProgramReqDto addProgramReqDto) throws Exception {
		Program programEntity = addProgramReqDto.toEntity();
		
		List<MultipartFile> pFiles = new ArrayList<MultipartFile>();
		pFiles.add(addProgramReqDto.getImgUrl_1());
		pFiles.add(addProgramReqDto.getImgUrl_2());
		
		String[] Array = new String[2];

		if(predicate.test(addProgramReqDto.getImgUrl_1().getOriginalFilename())
				&& predicate.test(addProgramReqDto.getImgUrl_2().getOriginalFilename())) {
			
			for (int i = 0; i < pFiles.size(); i++) {
				String originFilename = pFiles.get(i).getOriginalFilename();
				String tempFilename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originFilename;
				
				Path uploadPath = Paths.get(filepath, "program/" + tempFilename);
				
				File f = new File(filepath + "program");
				
				if(!f.exists()) {
					f.mkdir();
				}
				
				Files.write(uploadPath, pFiles.get(i).getBytes());
				
				Array[i] = tempFilename;
			}
		}
		programEntity.setProgram_imgUrl_1(Array[0]);
		programEntity.setProgram_imgUrl_2(Array[1]);
	
		return programRepository.addProgram(programEntity);
	}

	@Override
	public List<ProgramListRespDto> getProgramList(String theme) throws Exception {
		
		List<ProgramListRespDto> list = new ArrayList<ProgramListRespDto>();
		
		programRepository.GetProgramList(theme).forEach(program -> {
			list.add(program.toListDto());
		});
		
		return list;
	}

	@Override
	public Program getProgramDetail(int code) throws Exception {
		Program program = null;
		
		program = programRepository.GetProgramDetail(code);
		
		return program;
	}

	@Override
	public boolean addHeart(int code) throws Exception {
		return programRepository.addHeart(code);
	}

	@Override
	public boolean subHeart(int code) throws Exception {
		return programRepository.subHeart(code);
	}

	@Override
	public boolean createOrder(Map<String, Integer> codes) {
		return programRepository.createOrder(codes);
	}

	@Override
	public boolean updateprogram(AddProgramReqDto addProgramReqDto) throws Exception {
		Program programUpdateEntity = addProgramReqDto.updateEntity();
		return programRepository.updateProgram(programUpdateEntity);
	}

	@Override
	public boolean deleteprogram(int code) throws Exception {
		return programRepository.deleteProgram(code);
	}
}

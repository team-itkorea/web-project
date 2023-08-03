package com.example.practice.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	@Value("${file.path}")
	private String filepath;
	
	private final AdminRepository adminRepository;
	
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
	
		return adminRepository.addProgram(programEntity);
	}
	
}

package com.example.visualization.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.visualization.entity.User;

public interface HomeService {

	boolean hasCSVFormat(MultipartFile file);

	void processAndSaveData(MultipartFile file);

	public List<User> getAll();
	

}

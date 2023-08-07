package com.example.visualization.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.visualization.entity.User;
import com.example.visualization.repository.UserRepository;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public boolean hasCSVFormat(MultipartFile file) {
		String type="text/csv";
		if(!type.equals(file.getContentType()))
			return false;
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file) {
		
	try {
		List<User> users=csvToUsers(file.getInputStream());
		repository.saveAll(users);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private List<User> csvToUsers(InputStream inputStream) {
		try(BufferedReader fileReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
				CSVParser csvParser=new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
			List<User> users=new ArrayList<User>();
			List<CSVRecord> record= csvParser.getRecords();
			for(CSVRecord csvrecord : record) {
				User user=new User(Long.parseLong(csvrecord.get("intensity")),
						csvrecord.get("likelihood"), csvrecord.get("relevance"), csvrecord.get("end_year"),
						csvrecord.get("country"),csvrecord.get("topic"), csvrecord.get("region"), csvrecord.get("city"));
				users.add(user);
				System.out.println(user);
			}
			return users;
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return repository.findAll();
	}

}

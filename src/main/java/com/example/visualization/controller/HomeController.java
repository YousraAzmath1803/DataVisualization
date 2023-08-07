package com.example.visualization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.visualization.response.Response;
import com.example.visualization.service.HomeService;

@RestController
@RequestMapping("/files")
public class HomeController {
	
@Autowired
 private HomeService homeService;
@CrossOrigin
@PostMapping("/upload")
public ResponseEntity<Response>  uploadFile(@RequestParam("file") MultipartFile file){
	if(homeService.hasCSVFormat(file)) {
		
		homeService.processAndSaveData(file);
		return ResponseEntity.status(HttpStatus.OK).body(new Response("Uploaded file successfully :"+file.getOriginalFilename()));

		
	}
	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response("Please upload CSV file"));
	
}
@CrossOrigin
@GetMapping("/get")
public ResponseEntity<?> getAllProduct(){
	return new ResponseEntity<>(homeService.getAll(),HttpStatus.OK);
	 
	


	
}

}

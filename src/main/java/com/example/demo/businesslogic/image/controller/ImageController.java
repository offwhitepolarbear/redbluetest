package com.example.demo.businesslogic.image.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	private String filePath= "C:\\0\\000\\";
	
	@PostMapping("/upload")
	public void imageUpload(MultipartFile[] uploadFiles) {
		for (MultipartFile uploadFile: uploadFiles) {
			
			String originalName = uploadFile.getOriginalFilename();
			Timestamp timestampNow = new Timestamp(System.currentTimeMillis());
			String fileName = timestampNow.getTime() + originalName ;
			Path savePathFileName = Paths.get(filePath + fileName); 
			
			try {
				uploadFile.transferTo(savePathFileName);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/download/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName){
		
		File file = new File(filePath+fileName);
		InputStreamResource resource = null;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        	
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-disposition", "attachment; filename=" + fileName);
        responseHeaders.add("Content-Type",MediaType.IMAGE_JPEG_VALUE);

        return new ResponseEntity(resource, responseHeaders, HttpStatus.OK);
	}
	
}

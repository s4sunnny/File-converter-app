package com.sunny.fileConverter.pdf.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.fileConverter.pdf.service.ImageToPdfService;

@RestController
public class ImageToPdfController {

	
	@Autowired
	private ImageToPdfService imageToPdfService;
	
	@PostMapping("/convertImageToPdf")
	public ResponseEntity<Object> uploadFile(@RequestParam("files") List<MultipartFile> uploadfile) throws IOException {
		return imageToPdfService.convertImageToPdf(uploadfile);
    }
}

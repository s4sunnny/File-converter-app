package com.sunny.fileConverter.Image.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.fileConverter.Image.service.ImageToTextService;

@RestController
public class ImageToTextConverter {

	@Autowired
	private ImageToTextService imageToTextService;
	
	@PostMapping(value = "/convertImageToText")
	public String convertImageToText(@RequestParam("files") MultipartFile uploadfile) throws IOException {

		return imageToTextService.convertImageToText(uploadfile);
	}
}

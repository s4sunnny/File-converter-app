package com.sunny.fileConverter.pdf.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sunny.fileConverter.pdf.service.PdfToJpgService;

@RestController
public class PdfToJpgController {

	@Autowired
	private PdfToJpgService pdfToJpgService;
	
	@PostMapping(value = "/convert-pdf-to-jpg")
	public ResponseEntity<Object> uploadFile(@RequestParam("files") MultipartFile uploadfile) throws IOException {

		return pdfToJpgService.convertPdfToJpg(uploadfile);
	}
}

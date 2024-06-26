package com.sunny.fileConverter.pdf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.fileConverter.pdf.service.PdfToJpgService;

@RestController
public class PdfToJpgController {

	@Autowired
	private PdfToJpgService pdfToJpgService;

	@PostMapping(value = "/convert-pdf-to-jpg")
	public ResponseEntity<Object> uploadFile(@RequestParam("files") MultipartFile uploadfile,
			@RequestParam("type") String fileType) throws IOException {

		return pdfToJpgService.convertPdfToJpg(uploadfile, fileType);
	}
}

package com.sunny.fileConverter.pdf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.fileConverter.pdf.service.PdfToDocService;

@RestController
public class PdfToDocController {

	@Autowired
	private PdfToDocService pdfToDocService;

	@PostMapping(value = "/convert-pdf-to-Doc")
	public ResponseEntity<Object> uploadFile(@RequestParam("files") MultipartFile uploadfile) throws IOException {

		return pdfToDocService.convertPdfToDoc(uploadfile);
	}
}

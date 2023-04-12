package com.sunny.fileConverter.pdf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.fileConverter.pdf.service.PdfToTextService;

@RestController
public class PdfToTextController {

	@Autowired
	private PdfToTextService pdfToTextService;

	@PostMapping(value = "/convert-pdf-to-text")
	public String uploadFile(@RequestParam("files") MultipartFile uploadfile) throws IOException {

		return pdfToTextService.convertPdfToText(uploadfile);
	}
}

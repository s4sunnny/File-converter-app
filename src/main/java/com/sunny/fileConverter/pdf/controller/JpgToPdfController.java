package com.sunny.fileConverter.pdf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.sunny.fileConverter.pdf.service.JpgToPdfService;

@RestController
public class JpgToPdfController {

	
	@Autowired
	private JpgToPdfService jpgToPdfService;
	
	@GetMapping("/convertJpgToPdf")
	 public String convertJpgToPdf(String inputFile, String outputFile) throws DocumentException, IOException {
        jpgToPdfService.convertJpgToPdf(inputFile, outputFile);
		return outputFile;
    }
}

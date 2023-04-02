package com.sunny.fileConverter.pdf.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class JpgToPdfService {

	public void convertJpgToPdf(String inputFile, String outputFile) throws DocumentException, IOException {
		 Document document = new Document();
	        FileOutputStream fos = new FileOutputStream(outputFile);
	        PdfWriter.getInstance(document, fos);
	        document.open();
	        Image image = Image.getInstance(inputFile);
	        document.add(image);
	        document.close();
	        fos.close();
	}

}

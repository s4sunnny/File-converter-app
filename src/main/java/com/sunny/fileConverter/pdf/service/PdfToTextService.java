package com.sunny.fileConverter.pdf.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfToTextService {

	public String convertPdfToText(MultipartFile uploadfile) throws FileNotFoundException, IOException {

		File file = new File(uploadfile.getOriginalFilename());
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(uploadfile.getBytes());
		}
		PDDocument document = PDDocument.load(file);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		document.close();
		return text;
	}

}

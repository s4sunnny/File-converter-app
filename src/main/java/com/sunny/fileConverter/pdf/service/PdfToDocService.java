package com.sunny.fileConverter.pdf.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

@Service
public class PdfToDocService {

	public ResponseEntity<Object> convertPdfToDoc(MultipartFile uploadfile) {
		try {
			// Load the PDF document
			File file = new File(uploadfile.getOriginalFilename());
			try (OutputStream os = new FileOutputStream(file)) {
				os.write(uploadfile.getBytes());
			}
			// Create a PdfDocument object
			PdfDocument doc = new PdfDocument();

			// Load a sample PDF document
			doc.loadFromStream(uploadfile.getInputStream());

			// Convert PDF to Word with flowable structure
			doc.getConvertOptions().setConvertToWordUsingFlow(true);

			// Convert PDF to Doc
			doc.saveToFile("output/ToDoc.doc", FileFormat.DOC);

			// Convert PDF to Docx
			doc.saveToFile("output/ToDocx.docx", FileFormat.DOCX);
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

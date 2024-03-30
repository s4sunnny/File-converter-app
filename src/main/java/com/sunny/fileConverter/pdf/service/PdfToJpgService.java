package com.sunny.fileConverter.pdf.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.preflight.PreflightDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfToJpgService {

	public ResponseEntity<Object> convertPdfToJpg(MultipartFile uploadfile, String fileType) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] imageData = null;
		try {
			// Load the PDF document
			File file = new File(uploadfile.getOriginalFilename());
			try (OutputStream os = new FileOutputStream(file)) {
				os.write(uploadfile.getBytes());
			}
			PDDocument document = PDDocument.load(file);
			// Validate the PDF document
			if (!document.isEncrypted() && document.getNumberOfPages() > 0) {
				// Convert each page to a JPG image
				PDFRenderer renderer = new PDFRenderer(document);
				for (int i = 0; i < document.getNumberOfPages(); i++) {
					BufferedImage image = renderer.renderImage(i, 1.0f);
					ImageIO.write(image, fileType, baos);
					imageData = baos.toByteArray();
				}
			}

			// Close the PDF document
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
//		 InputStreamResource fileInputStream = new InputStreamResource(bais);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
		// defining the custom Content-Type
		headers.set(HttpHeaders.CONTENT_TYPE, "image/jpeg");

		String base64Image = Base64.getEncoder().encodeToString(imageData);
		String responseData = "data:image/" + fileType + ";base64," + base64Image;
		return new ResponseEntity<>(responseData, headers, HttpStatus.OK);
	}

}

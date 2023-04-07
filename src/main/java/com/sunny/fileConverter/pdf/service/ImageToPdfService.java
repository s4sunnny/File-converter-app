package com.sunny.fileConverter.pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ImageToPdfService {

	public ResponseEntity<Object> convertImageToPdf(List<MultipartFile> uploadfile) {
		// Create a new PDF document
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		byte[] pdfBytes = null;
		try {
			// Create a new PDF writer
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, out);

			// Open the document
			document.open();

			// Loop through the image files
			for (MultipartFile file : uploadfile) {
				// Get the input stream from the Multipart file
				InputStream inputStream = file.getInputStream();

				// Read the image from the input stream
				Image image = Image.getInstance(ImageIO.read(inputStream), null);

				// Add the image to the PDF document
				document.add(image);

				// Close the input stream
				inputStream.close();
			}

			// Close the PDF document
			document.close();

			// Get the PDF bytes from the output stream
			pdfBytes = out.toByteArray();

			// Do something with the PDF bytes (e.g. save to file or return in response)
			// ...
		} catch (Exception ex) {
			// Handle exceptions
			// ...
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
		// defining the custom Content-Type
		headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");
		return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}

}

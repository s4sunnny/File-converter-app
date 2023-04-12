package com.sunny.fileConverter.Image.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aspose.ocr.AsposeOCR;

@Service
public class ImageToTextService {

	public String convertImageToText(MultipartFile uploadfile)throws FileNotFoundException, IOException  {
		String result = "";
		File file = new File(uploadfile.getOriginalFilename());
		try (OutputStream os = new FileOutputStream(file)) {
			os.write(uploadfile.getBytes());
		}
		
		AsposeOCR api = new AsposeOCR();

		// Recognize page by full path to file
		try {
			result = api.RecognizePage(file.getAbsolutePath());
			System.out.println("Result: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}

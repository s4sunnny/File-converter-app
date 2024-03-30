package com.sunny.fileConverter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RedirectController {

	@GetMapping(value = "/searchHtml2Pdf")
	public ModelAndView searchHtml2Pdf(ModelAndView model) {

		model.setViewName("PDF/html2pdf");
		return model;
	}
	
	@GetMapping(value = "/searchImageToPdfView")
	public ModelAndView searchJpgToPdf(ModelAndView model) {

		model.setViewName("PDF/imageToPdf/ImageToPdf");
		return model;
	}
	
	@GetMapping(value = "/searchPdfToJpgView")
	public ModelAndView searchPdfToJpgView(ModelAndView model) {

		model.setViewName("PDF/pdfToImage/pdfToJpg");
		return model;
	}

	@GetMapping(value = "/getPdfToJpgView")
	public ModelAndView getCommonPageForConverted(ModelAndView model) {

		model.setViewName("PDF/pdfToImage/pdfToImageView");
		return model;
	}
	
	@GetMapping(value = "/getJpgToPdfView")
	public ModelAndView getJpgToPdfView(ModelAndView model) {

		model.setViewName("PDF/imageToPdf/ImageToPdfView");
		return model;
	}
	
	@GetMapping(value = "/getPdfToTextView")
	public ModelAndView getPdfToTextView(ModelAndView model) {

		model.setViewName("PDF/pdfToText/pdfToTextView");
		return model;
	}
	
	@GetMapping(value = "/searchPdfToTextView")
	public ModelAndView searchPdfToTextView(ModelAndView model) {

		model.setViewName("PDF/pdfToText/pdfToText");
		return model;
	}
	
	@GetMapping(value = "/getImageToTextView")
	public ModelAndView getImageToTextView(ModelAndView model) {

		model.setViewName("Image/imageToTextView");
		return model;
	}
	
	@GetMapping(value = "/searchImageToTextView")
	public ModelAndView searchImageToTextView(ModelAndView model) {

		model.setViewName("Image/imageToText");
		return model;
	}
	
	@GetMapping(value = "/searchPdfToDocView")
	public ModelAndView searchPdfToDocView(ModelAndView model) {

		model.setViewName("PDF/PDFtoDOC/addPdfToDoc");
		return model;
	}
	
}

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
	
	@GetMapping(value = "/searchJpgToPdf")
	public ModelAndView searchJpgToPdf(ModelAndView model) {

		model.setViewName("PDF/JpgToPdf");
		return model;
	}
	
	@GetMapping(value = "/searchPdfToJpgView")
	public ModelAndView searchPdfToJpgView(ModelAndView model) {

		model.setViewName("PDF/pdfToJpg");
		return model;
	}

	@GetMapping(value = "/getCommonPageForConverted")
	public ModelAndView getCommonPageForConverted(ModelAndView model) {

		model.setViewName("PDF/afterConversionCommanView/commonPageForView");
		return model;
	}
	
}

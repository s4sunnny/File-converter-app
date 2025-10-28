package com.sunny.fileConverter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@GetMapping("/")
	public ModelAndView getHomePage(ModelAndView model) {
		model.setViewName("home");
		return model;
	}
	
}

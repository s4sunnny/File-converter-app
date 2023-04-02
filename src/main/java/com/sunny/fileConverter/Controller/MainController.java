package com.sunny.fileConverter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String index() {
		return "home";
	}
	
	@GetMapping(value = "/home")
	public ModelAndView home(ModelAndView model) {
		model.setViewName("home");
		return model;
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
}

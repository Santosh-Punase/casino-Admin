package com.nagarro.casino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView homeView = new ModelAndView("index");
		return homeView;
	}
}

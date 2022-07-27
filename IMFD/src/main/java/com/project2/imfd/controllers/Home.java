package com.project2.imfd.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.Application;
@SuppressWarnings("unused")
@Controller
public class Home {
	private static Logger LOGGER = LogManager.getLogger(Home.class);
	@RequestMapping("/home")
	public String showHome() {
		LOGGER.info("the home method has been called");
		return "home";
	}
	
}

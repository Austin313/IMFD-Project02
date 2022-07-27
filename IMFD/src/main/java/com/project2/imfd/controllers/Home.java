package com.project2.imfd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@Controller
public class Home {
	
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}

}

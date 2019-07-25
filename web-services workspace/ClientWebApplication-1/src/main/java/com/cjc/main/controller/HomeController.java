package com.cjc.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/getData")
	public String getData()
	{
		return "Welcome in Micro-Service";
	}

}

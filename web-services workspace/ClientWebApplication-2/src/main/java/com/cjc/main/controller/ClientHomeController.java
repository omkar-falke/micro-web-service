package com.cjc.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientHomeController {
@RequestMapping("/getData")
	public String getData()
	{
		return "Welocome in cjc client web application";
	}

}

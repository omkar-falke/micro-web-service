package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/reg")
	public List reg()
	{
		String url="http://zuul/getproduce/reg";
		//String url="http://desktop-da8vt77:8087/reg";
		List al=restTemplate.getForObject(url,List.class);
		return al;
	}
}

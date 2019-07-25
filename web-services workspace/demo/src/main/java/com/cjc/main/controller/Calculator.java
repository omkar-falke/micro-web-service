package com.cjc.main.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {
	
	
	@RequestMapping("/calculator")
	public String check()
	{
		return "calculator";
	}
	
	@PostMapping("/add/{no1}/{no2}")
	public String add(@PathVariable int no1,@PathVariable int no2)
	{
		int sum=no1+no2;
		return "Sum = "+sum;
	}
	
	@PostMapping("/sub/{no1}/{no2}")
	public String sub(@PathVariable int no1,@PathVariable int no2)
	{
		int sub=no1-no2;
		return "Sub = "+sub;
	}
	
	@PostMapping("/multi/{no1}/{no2}")
	public String multi(@PathVariable int no1,@PathVariable int no2)
	{
		int multi=no1*no2;
		return "multi = "+multi;
	}
	
	@PostMapping("/div/{no1}/{no2}")
	public String div(@PathVariable int no1,@PathVariable int no2)
	{
		int div=no1/no2;
		return "div = "+div;
	}
	
	
	
	
	
	
	
	
}

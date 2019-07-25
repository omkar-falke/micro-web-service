package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.ServiceI;

@RestController
public class HomeController {
	
	@Autowired
	ServiceI si;
	@GetMapping("/getData")
	public List<Employee>getData()
	{
		List<Employee>list=si.getData();
		
		return list;
	}	
}

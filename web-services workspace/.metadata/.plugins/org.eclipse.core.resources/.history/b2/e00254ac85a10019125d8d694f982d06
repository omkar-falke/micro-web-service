package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.ServiceI;

@RestController
public class HomeController {
	
	@Autowired
	ServiceI si;
	@PutMapping("/updateData")
	public String updateData(@RequestBody Employee e)
	{
		si.updataData(e);
		return "Data Updated.";
	}

}

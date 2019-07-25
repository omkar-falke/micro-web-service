package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.service.ServiceI;

@RestController
public class HomeController {
	
	@Autowired
	ServiceI si;
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable(name="id")int id)
	{
		si.deleteData(id);
		return "Data is Deleted";
	}
	
	

}

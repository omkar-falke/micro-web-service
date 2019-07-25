package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.ServiceI;

@RestController
public class HomeController {
	
	@Autowired
	ServiceI si;
	
	@PostMapping("/setData")
	public String setData(@RequestBody Employee e)
	{
		si.setData(e);
		return "Data Inserted Successfully.";
		
	}
	
	@GetMapping("/getData")
	public List<Employee>getData()
	{
		List<Employee>list=si.getData();
		
		return list;
	}
	
	@PutMapping("/updateData")
	public String updateData(@RequestBody Employee e)
	{
		si.updataData(e);
		return "Data Updated.";
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable(name="id")int id)
	{
		si.deleteData(id);
		return "Data is Deleted";
	}
	
	

}

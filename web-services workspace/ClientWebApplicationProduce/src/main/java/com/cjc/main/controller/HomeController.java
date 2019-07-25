package com.cjc.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;

@RestController
public class HomeController {
	
	@RequestMapping("/reg")
	public List<Student>reg()
	{
		Student s=new Student();
		s.setRollno(101);
		s.setName("Omkar");
		s.setAddress("pune");
		List<Student>list=new ArrayList<>();
		list.add(s);
		return list;
		
	}

}

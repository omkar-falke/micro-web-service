package com.cjc.main.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.main.model.Employee;

public interface EmployeeService {
	
	public List<Employee>getData();

	public boolean createPdf(List<Employee> list, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}

package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Employee;

public interface ServiceI 
{
	public List<Employee>checkLogin(String username,String password);
}

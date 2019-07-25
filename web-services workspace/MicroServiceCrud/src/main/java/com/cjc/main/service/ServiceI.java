package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Employee;

public interface ServiceI 
{
	public void setData(Employee e);
	public List<Employee>getData();
	public void updataData(Employee e);
	public void deleteData(int id);
}
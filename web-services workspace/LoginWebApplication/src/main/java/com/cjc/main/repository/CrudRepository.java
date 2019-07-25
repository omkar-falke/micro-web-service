package com.cjc.main.repository;

import java.util.List;

import com.cjc.main.model.Employee;

public interface CrudRepository  extends org.springframework.data.repository.CrudRepository<Employee, Integer>{

	public List<Employee>findByUsernameAndPassword(String username,String password);
	
}

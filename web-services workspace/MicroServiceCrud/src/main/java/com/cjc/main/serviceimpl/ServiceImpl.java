package com.cjc.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.CrudRepository;
import com.cjc.main.service.ServiceI;

@Service
public class ServiceImpl implements ServiceI
{
	@Autowired
	CrudRepository cr;
	@Override
	public void setData(Employee e) {
		cr.save(e);
	}

	@Override
	public List<Employee> getData() {
		List<Employee>list=(List<Employee>) cr.findAll();
		return list;
	}

	@Override
	public void updataData(Employee e) {
		// TODO Auto-generated method stub
		cr.save(e);
		
	}

	@Override
	public void deleteData(int id) {
		
		cr.deleteById(id);
		
	}
	

}

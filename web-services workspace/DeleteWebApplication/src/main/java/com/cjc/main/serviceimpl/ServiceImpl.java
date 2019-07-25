package com.cjc.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.repository.CrudRepository;
import com.cjc.main.service.ServiceI;

@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	CrudRepository cr;

	@Override
	public void deleteData(int id) {
		cr.deleteById(id);

	}

}

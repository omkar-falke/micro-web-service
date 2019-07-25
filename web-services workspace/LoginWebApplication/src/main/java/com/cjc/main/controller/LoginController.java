package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.service.ServiceI;

@RestController
public class LoginController {

	@Autowired
	ServiceI si;

	@RequestMapping("/login/{username}/{password}")
	public String checkLogin(@PathVariable(name = "username") String username,
			@PathVariable(name = "password") String password) {
		si.checkLogin(username, password);
		return "Welcome!Login Successfull.";
	}

}

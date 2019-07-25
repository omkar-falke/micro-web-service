package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.ServiceI;
import com.cjc.main.serviceimpl.NotificationService;

@RestController
public class HomeController {
	
	@Autowired
	ServiceI si;
	@Autowired
	private NotificationService  notificationService;
	@PostMapping("/setData")
	public String setData(@RequestBody Employee e1)
	{
		si.setData(e1);
		
		try {
			notificationService.sendNotification(e1);
		} catch (MailException e) {
			
			//log.info("Error message......."+e.getMessage());
		}
		
		return "Data Inserted Successfully.";
		
		
	}
}

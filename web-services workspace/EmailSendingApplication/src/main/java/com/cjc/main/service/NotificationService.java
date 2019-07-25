package com.cjc.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.main.model.User;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(User user)throws MailException
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("omkar.falke95@gmail.com");
		mail.setSubject("Mail Notification");
		mail.setText("This is for test Purpose.");
		javaMailSender.send(mail);
	}
	
}
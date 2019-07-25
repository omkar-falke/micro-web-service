package com.cjc.main.serviceimpl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Employee;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(Employee employee)throws MailException
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(employee.getEmail());
		mail.setFrom("omkar.falke95@gmail.com");
		mail.setSubject("Mail Notification");
		mail.setText("Welcome!"+employee.getName()+" "+"Your Registration Successfull"+"\n"+"Your Username:&"+employee.getUsername()+" "+"Password"+" "+employee.getPassword());
		javaMailSender.send(mail);
	}
	
}

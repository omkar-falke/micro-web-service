package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfExcelWebApplication {

	public static void main(String[] args) {
		System.out.println("PDF Generation");
		SpringApplication.run(PdfExcelWebApplication.class, args);
	}

}

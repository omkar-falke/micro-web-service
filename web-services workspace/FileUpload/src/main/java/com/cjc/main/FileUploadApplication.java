package com.cjc.main;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cjc.main.controller.FileUpload;

@SpringBootApplication
@ComponentScan("com")
public class FileUploadApplication {

	public static void main(String[] args) {
		new File(FileUpload.uploadDirectory).mkdir();
		SpringApplication.run(FileUploadApplication.class, args);
	}

}

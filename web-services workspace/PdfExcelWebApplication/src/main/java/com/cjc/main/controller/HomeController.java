package com.cjc.main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cjc.main.model.Employee;
import com.cjc.main.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	EmployeeService es;
	@Autowired
	private ServletContext context;

	@GetMapping("/")
	public String getData(Model model) {
		List<Employee> list = es.getData();
		model.addAttribute("emp", list);
		return "view/employees";
	}

	@GetMapping("/createPdf")
	public String download(HttpServletRequest request, HttpServletResponse response) {
		List<Employee> list = es.getData();
		
		for(Employee employee:list)
		{
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
		}
		
		boolean flag = es.createPdf(list, context, request, response);
		if (flag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/" + "list" + ".pdf");
			System.out.println("1.fullPath......................."+fullPath);
			filedownload(fullPath, response, "list.pdf");
		}
		return null;
	}

	private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		File file = new File(fullPath);
		final int BUUFER_SIZE = 4096;
		if (file.exists()) {
			try {

				FileInputStream fileInputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-disposition", "attachment;filename=" + fileName);
				OutputStream write = response.getOutputStream();
				byte buffer[] = new byte[BUUFER_SIZE];
				int byteRead = -1;

				while ((byteRead = fileInputStream.read(buffer)) != -1) {
					write.write(buffer, 0, byteRead);
				}
				fileInputStream.close();
				write.close();
				file.delete();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

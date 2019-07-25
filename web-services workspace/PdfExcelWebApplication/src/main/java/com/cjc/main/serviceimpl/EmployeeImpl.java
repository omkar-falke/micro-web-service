package com.cjc.main.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.EmployeeRepo;
import com.cjc.main.service.EmployeeService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional
public class EmployeeImpl  implements EmployeeService{

	@Autowired 
	EmployeeRepo er;
	@Override
	public List<Employee> getData() {
		List<Employee>list=(List<Employee>) er.findAll();
		return list;
	}
	@Override
	public boolean createPdf(List<Employee> list, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Pdf Generator ....................................");
		Document document=new Document(PageSize.A4,15,15,45,30);
		try {
			
			String filePath=context.getRealPath("/resources/reports");
			System.out.println("filePath............................."+filePath);
			File file=new File(filePath);
			boolean exit=new File(filePath).exists();
			System.out.println("1-----------------------"+exit);
			if(!exit)
			{
				System.out.println("false----------------------------------");
				new File(filePath).mkdir();
			}
			PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"list"+".pdf"));
			document.open();
			Font mainFont=FontFactory.getFont("Arial",10,BaseColor.BLACK);
			Paragraph paragraph=new Paragraph("All Employee Data ",mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);
			
			PdfPTable table=new PdfPTable(8);
			
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);
			Font tableHeader=FontFactory.getFont("Arial",10,BaseColor.BLACK);
			Font tablebody=FontFactory.getFont("Arial",9,BaseColor.BLACK);
			
			PdfPCell firstName=new PdfPCell(new Paragraph("First Name",tableHeader));
			firstName.setBorderColor(BaseColor.BLACK);
			firstName.setPaddingLeft(10);
			firstName.setHorizontalAlignment(Element.ALIGN_CENTER);
			firstName.setVerticalAlignment(Element.ALIGN_CENTER);
			firstName.setBackgroundColor(BaseColor.GRAY);
			firstName.setExtraParagraphSpace(5f);
			table.addCell(firstName);
			
			PdfPCell middleName=new PdfPCell(new Paragraph("Middle Name",tableHeader));
			middleName.setBorderColor(BaseColor.BLACK);
			middleName.setPaddingLeft(10);
			middleName.setHorizontalAlignment(Element.ALIGN_CENTER);
			middleName.setVerticalAlignment(Element.ALIGN_CENTER);
			middleName.setBackgroundColor(BaseColor.GRAY);
			middleName.setExtraParagraphSpace(5f);
			table.addCell(middleName);
			
			PdfPCell lastName=new PdfPCell(new Paragraph("LastName",tableHeader));
			lastName.setBorderColor(BaseColor.BLACK);
			lastName.setPaddingLeft(10);
			lastName.setHorizontalAlignment(Element.ALIGN_CENTER);
			lastName.setVerticalAlignment(Element.ALIGN_CENTER);
			lastName.setBackgroundColor(BaseColor.GRAY);
			lastName.setExtraParagraphSpace(5f);
			table.addCell(lastName);
			
			
			for(Employee employee:list)
			{
				

				PdfPCell firstNameValue=new PdfPCell(new Paragraph(employee.getFirstName(),tablebody));
				firstNameValue.setBorderColor(BaseColor.BLACK);
				firstNameValue.setPaddingLeft(10);
				firstNameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				firstNameValue.setVerticalAlignment(Element.ALIGN_CENTER);
				firstNameValue.setBackgroundColor(BaseColor.WHITE);
				firstNameValue.setExtraParagraphSpace(5f);
				table.addCell(firstNameValue);
			}
			
			
			document.add(table);
			document.close();
			writer.close();
			return false;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}

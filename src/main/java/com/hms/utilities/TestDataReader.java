package com.hms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {
	public static void main(String[] args) {
		int rowcount;
		int cell_count;
	
///HMS_AUTOMATION/Testdata/Testdata.xlsx
	try {
		FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/Testdata/Testdata.xlsx"));
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//System.out.println(workbook.getSheetName(0));
			XSSFSheet sheet=workbook.getSheet("doctors");
			 rowcount=sheet.getLastRowNum();
			 cell_count=sheet.getRow(0).getLastCellNum();
			 System.out.println("Doctor_name <<=====>> Specialization");
			for(int i=1;i<=rowcount;i++) {
				
					String doctor=sheet.getRow(i).getCell(0).getStringCellValue();
					String specialization=sheet.getRow(i).getCell(1).getStringCellValue();
					System.out.println(doctor+"<<======>>"+specialization);
				}
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}}

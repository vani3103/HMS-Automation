package com.hms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader2 {
	public static void main(String[] args) {
		int rowcount;
		int cell_count;
	
///HMS_AUTOMATION/Testdata/Testdata.xlsx
	try {
		FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/Testdata/Testdata.xlsx"));
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//System.out.println(workbook.getSheetName(0));
			XSSFSheet sheet=workbook.getSheet("patients");
			 rowcount=sheet.getLastRowNum();
			 cell_count=sheet.getRow(0).getLastCellNum();
			for(int i=0;i<=rowcount;i++) {
				for(int j=0;j<cell_count;j++) {
					String data=sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data);
				}
				
				
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

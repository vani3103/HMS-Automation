package com.hms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hms.testbase.TestBase;

public class GetTestData extends TestBase {
public static String test_data_sheet_path="/Testdata/Testdata.xlsx";
public static Object[][] gettestdata(String sheetname) throws Exception
{
		FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/Testdata/Testdata.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//System.out.println(workbook.getSheetName(0));
			XSSFSheet sheet=workbook.getSheet(sheetname);
			int  rowcount=sheet.getLastRowNum();
			int  cell_count=sheet.getRow(0).getLastCellNum();
			Object[][] data=new Object[rowcount][cell_count];
			//sheet.getRow(i).getCell(j).getStringCellValue();
			for(int i=0;i<rowcount;i++) {
				for(int j=0;j<cell_count;j++) {
					data[i][j]=sheet.getRow(i).getCell(j).toString();
					//System.out.println(data);
				}
				
			}
	return data;
	
}
}

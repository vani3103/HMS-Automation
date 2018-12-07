package com.hms.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.pages.AddNewPatientPage;
import com.hms.pages.AppointmentsPage;
import com.hms.pages.HomePage;
import com.hms.pages.PatientsPage;
import com.hms.pages.SavePatientPage;
import com.hms.testbase.TestBase;
import com.hms.utilities.GetTestData;

public class PatientsPageTest extends TestBase{
	HomePage homepage;
	AppointmentsPage appointmentspage;
	PatientsPage patientspage;
	AddNewPatientPage addnewpatientpage;
	SavePatientPage savepatientpage;
	GetTestData gettestdata;
	String sheet_name="patients";


	public PatientsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		appointmentspage=homepage.Login(prop.getProperty("username"), prop.getProperty("password"));
		appointmentspage.clickon_patientsLink();
		patientspage=new PatientsPage();
		addnewpatientpage=new AddNewPatientPage();
		savepatientpage=new SavePatientPage();
		gettestdata=new GetTestData();
		
	}

	@DataProvider
	public Object[][] get_testData() throws Exception
	{
		Object[][] data=gettestdata.gettestdata(sheet_name);
		return data;
	}

	@Test(priority=1)
	public void verify_pagetitle() {
		//System.out.println("hi");
		patientspage.gettitle();
		
	}

	@Test(dataProvider="get_testData")
	public void add_patient(String pname,String pSex,String pLocation)
	{
		patientspage.createPatient();
		
		addnewpatientpage.create_Patient(pname, pSex, pLocation);
		savepatientpage.verify_sucessmessage();
		savepatientpage.click_continue();
		appointmentspage.clickon_patientsLink();
		
	}
	
	@Test(priority=4)
	public void Modify_patient_data()
	{
		patientspage.modify_patient_data("test");
		
	}

	@Test(priority=5)
	public void Delete_patient_data()
	{
		patientspage.delete_patient_data("pat");
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

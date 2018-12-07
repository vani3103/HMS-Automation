package com.hms.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.pages.AddDoctorPage;
import com.hms.pages.AppointmentsPage;
import com.hms.pages.DoctorsPage;
import com.hms.pages.HomePage;
import com.hms.pages.SaveDoctorPage;
import com.hms.testbase.TestBase;
import com.hms.utilities.GetTestData;

public class DoctorPageTest extends TestBase {
HomePage homepage;
AppointmentsPage appointmentspage;
DoctorsPage doctorspage;
AddDoctorPage adddoctorpage;
SaveDoctorPage savedoctorpage;
GetTestData gettestdata;
String sheetname="doctors";


public DoctorPageTest()
{
	super();
}
@BeforeMethod
public void setup() {
	initialization();
	homepage=new HomePage();
	appointmentspage=homepage.Login(prop.getProperty("username"), prop.getProperty("password"));
	appointmentspage.clickon_doctorsLink();
	doctorspage=new DoctorsPage();
	
	adddoctorpage=new AddDoctorPage();
	savedoctorpage=new SaveDoctorPage();
	gettestdata=new GetTestData();
	
}

@DataProvider
public Object[][] get_testData() throws Exception
{
	Object[][] data=gettestdata.gettestdata(sheetname);
	return data;
}

@Test(priority=1)
public void verify_pagetitle() {
	//System.out.println("hi");
	appointmentspage.gettitle();
	
}

@Test(priority=2)
public void add_Doctor_singleRecord()
{
	doctorspage.add_new_Doctor();
	adddoctorpage.create_doctor("sanjeev", "psychriartist");
	savedoctorpage.verify_sucessmessage();
	
}
@Test(priority=3,dataProvider="get_testData")
public void add_multiple_doctors(String doc_name,String spec)
{
	doctorspage.add_new_Doctor();
	adddoctorpage.create_doctor(doc_name, spec);
	savedoctorpage.verify_sucessmessage();
	savedoctorpage.verify_continue_link();
	appointmentspage.clickon_doctorsLink();
	//savedoctorpage.click_continue();
	
	}
@Test(priority=4)
public void Modify_doctor_data()
{
	doctorspage.modify_doctor_data("ddd");
	
}

@Test(priority=5)
public void Delete_doctor_data()
{
	doctorspage.delete_doctor_data("dkk");
}
@AfterMethod
public void teardown()
{
	driver.quit();
}
}

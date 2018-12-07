package com.hms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.pages.AppointmentsPage;
import com.hms.pages.HomePage;
import com.hms.testbase.TestBase;

public class AppointmentsPageTest extends TestBase {
HomePage homepage;
AppointmentsPage appointmentspage;
public  AppointmentsPageTest()
{
super();
}
@BeforeMethod
public void setup()
{
	initialization();
	homepage=new HomePage();
	appointmentspage=homepage.Login(prop.getProperty("username"), prop.getProperty("password"));
}
@Test(priority=1)
public void verify_adminpage_title()
{
	String title=appointmentspage.gettitle();
	System.out.println(title);
	
}

@Test(priority=2)
public void verify_doctorslink()
{
	boolean flag=appointmentspage.verify_doctorslink();
	Assert.assertTrue(flag);
}
@Test(priority=3)
public void verify_Patientslink()
{
	boolean flag=appointmentspage.verify_patients_link();
	Assert.assertTrue(flag);
}
@Test(priority=4)
public void verify_appoinitmentslink()
{
	boolean flag=appointmentspage.verify_appointmentsLink();
	Assert.assertTrue(flag);
}
@Test(priority=5)
public void verify_WelcomeMessage()
{
	boolean flag=appointmentspage.verify_WelcomeMsg();
	Assert.assertTrue(flag);
	
}
@Test(priority=6,enabled=false)
public void verify_hms_label()
{
	String labletext=appointmentspage.verify_HMS_lable(); 
	Assert.assertEquals(labletext, prop.getProperty("appointmentpage_hms_lable"));
}
@Test(priority=7)
public void verify_AddNewAppointment_link()
{
	boolean flag=appointmentspage.verify_AddNewAppointmentLink();
	Assert.assertTrue(flag);
}
@Test(priority=8)
public void add_new_appointment()
{
	appointmentspage.add_New_Appointment();
}
@AfterMethod
public void teardown()
{
	driver.quit();
}
}

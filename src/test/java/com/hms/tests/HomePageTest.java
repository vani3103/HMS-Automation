package com.hms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.pages.AppointmentsPage;
import com.hms.pages.HomePage;
import com.hms.testbase.TestBase;

public class HomePageTest extends TestBase {
HomePage homepage;
AppointmentsPage appointmentspage;
public HomePageTest()
{
	super();
	
}
@BeforeMethod
public void setup()
{
	 initialization();
	 homepage=new HomePage();
}
@Test(priority=1)
public void verify_HomePageTitle()
{
	
	String title=homepage.verify_pagetitle();
	//System.out.println(title);
	Assert.assertEquals(title, prop.getProperty("homepage_title"));
}
@Test(priority=2)
public void verify_LoginTest()
{
	appointmentspage=homepage.Login(prop.getProperty("username"), prop.getProperty("password"));
	String title=appointmentspage.gettitle();
	System.out.println(title);
}

@AfterMethod
public void teardown()
{
	driver.quit();
	
}
}

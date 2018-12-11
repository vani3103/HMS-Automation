package com.hms.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;
import com.hms.pages.AppointmentsPage;
import com.hms.pages.HomePage;
import com.hms.testbase.TestBase;
import com.qa.commonelements.Logout;

public class HomePageTest extends TestBase {
HomePage homepage;
AppointmentsPage appointmentspage;
Logout logout;
public HomePageTest()
{
	super();
	
}
@BeforeMethod
public void setup()
{
	 initialization();
	 
	 homepage=new HomePage();
	 logout=new Logout();
}
/*@Test(priority=1)
public void verify_HomePageTitle()
{
	
	String title=homepage.verify_pagetitle();
	//System.out.println(title);
	Assert.assertEquals(title, prop.getProperty("homepage_title"));
}*/
@Test(priority=2)
public void verify_LoginTest() throws Exception
{
	appointmentspage=homepage.Login(prop.getProperty("username"), prop.getProperty("password"));
	String title=appointmentspage.gettitle();
	System.out.println(title);
	logout.signout();
	
}

@AfterMethod
public void teardown()
{
	//driver.close();
	
}
}

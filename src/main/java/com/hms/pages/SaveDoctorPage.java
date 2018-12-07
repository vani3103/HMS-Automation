package com.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.testbase.TestBase;

public class SaveDoctorPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Continue...')]")
	WebElement  continue_link;
	@FindBy(xpath="//table//tr[4]//td")
	WebElement sucessmsg;
	public SaveDoctorPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	public boolean verify_continue_link()
	{
		return continue_link.isDisplayed();
		
	}
	
	public void verify_sucessmessage()
	{
		String sucess_msg=sucessmsg.getText();
		//System.out.println(sucess_msg);
		Assert.assertEquals(sucess_msg, prop.getProperty("Add_Record_sucessMsg"));
	}

	public void click_continue()
	{
		continue_link.click();
	}
}

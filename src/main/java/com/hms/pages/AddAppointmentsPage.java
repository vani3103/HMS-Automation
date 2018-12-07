package com.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class AddAppointmentsPage extends TestBase {
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	WebElement Signin_btn;
public AddAppointmentsPage()
{
	PageFactory.initElements(driver, this);
}
}

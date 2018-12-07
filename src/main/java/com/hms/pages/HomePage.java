package com.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(id="inputEmail")
	WebElement username;
	
	@FindBy(id="inputPassword")
	WebElement password;
	@FindBy(name="signIn")
	WebElement Signin_butoon;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verify_pagetitle()
	{
		return driver.getTitle();
	}
	
	public AppointmentsPage Login(String uid,String pwd)
	{
		username.sendKeys(uid);
		password.sendKeys(pwd);
		Signin_butoon.click();
		return new AppointmentsPage();
	}

}

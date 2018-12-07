package com.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;
	
public class AddNewPatientPage extends TestBase {
	@FindBy(name="name")
	WebElement patientname;
	
	@FindBy(name="sex")
	WebElement patient_gender;
	
	
	@FindBy(name="addr")
	WebElement patient_address;
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	WebElement signin_btn;
	
	
public AddNewPatientPage()
{
	PageFactory.initElements(driver, this);
}

public String gettitle()
{
	return driver.getTitle();
}

public boolean verify_signin_btn()
{
	return signin_btn.isDisplayed();
}
public SavePatientPage create_Patient(String name,String gender,String address)
{
	patientname.sendKeys(name);
	patient_gender.sendKeys(gender);
	patient_address.sendKeys(address);
	signin_btn.click();
	return new SavePatientPage();
	
	
}
}

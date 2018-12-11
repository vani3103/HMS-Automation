package com.hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hms.testbase.TestBase;

public class AddAppointmentsPage extends TestBase {
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	WebElement Signin_btn;
	
	@FindBy(name="tim")
	WebElement time_field;
	
	@FindBy(name="dat")
	WebElement date_field;
	
	
public AddAppointmentsPage()
{
	PageFactory.initElements(driver, this);
}
public void create_appointment(int patientid,int doctorid,String time,String date)
{
	Select selectpatient=new Select(driver.findElement(By.name("pat")));
	selectpatient.selectByIndex(patientid);
	Select selectdoctor=new Select(driver.findElement(By.name("doc")));
	selectdoctor.selectByIndex(doctorid);
	time_field.sendKeys(time);
	date_field.sendKeys(date);
	Signin_btn.click();
	
}
}

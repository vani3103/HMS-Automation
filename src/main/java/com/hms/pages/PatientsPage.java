package com.hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class PatientsPage extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Add New Patient')]")
	WebElement Add_new_patient_link;

	public PatientsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	public boolean verify_createPatientlink()
	{
		return Add_new_patient_link.isDisplayed();
	}
	
	public AddNewPatientPage createPatient()
	{
		Add_new_patient_link.click();
		return new AddNewPatientPage();
	}
	public void modify_patient_data(String name)
	{
		driver.findElement(By.xpath("//table//tr[5]//td/child::table//tr//td[contains(text(),'"+name+"')]//following-sibling::td//a[contains(text(),'Modify')]")).click();;
	}
	public void delete_patient_data(String name)
	{
		driver.findElement(By.xpath("//table//tr[5]//td/child::table//tr//td[contains(text(),'"+name+"')]//following-sibling::td//a[contains(text(),'Delete')]")).click();;
	}
}

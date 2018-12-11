package com.hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class AppointmentsPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Doctors')]")
	WebElement doctor_link; 
	
	@FindBy(xpath="//a[contains(text(),'Patients')]")
	WebElement patients_link;
	
	@FindBy(xpath="//a[contains(text(),'Appointments')]")
	WebElement appointments_link;
	
	@FindBy(xpath="//span[contains(text(),'Hello Admin !')]")
	WebElement welcomeMsg;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tr//td")
	WebElement hms_lable;
	
	@FindBy(xpath="//a[contains(text(),'Add New Appointments')]")
	WebElement AddNewAppointment_link;
	
	public AppointmentsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	public boolean verify_doctorslink()
	{
		return doctor_link.isDisplayed();
	}

	public boolean verify_patients_link()
	{
		return patients_link.isDisplayed();
	}
	public boolean verify_appointmentsLink()
	{
		return appointments_link.isDisplayed();
	}
	public boolean verify_WelcomeMsg()
	{
		return welcomeMsg.isDisplayed();
	}
	public String verify_HMS_lable()
	{
		return hms_lable.getText();
	}
	public boolean verify_AddNewAppointmentLink()
	{
		return AddNewAppointment_link.isDisplayed();
		
	}
	public DoctorsPage clickon_doctorsLink()
	{
		doctor_link.click();
		return new DoctorsPage();
	}
	public  PatientsPage clickon_patientsLink()
	{
		patients_link.click();
		return new PatientsPage();
	}
	public AddAppointmentsPage add_New_Appointment()
	{
		AddNewAppointment_link.click();
		return new AddAppointmentsPage();
		
	}
	public void delete_appointment(String name)
	{
		driver.findElement(By.xpath("//table//tr[6]//td/child::table//tr//td[contains(text(),'"+name+"')]//following-sibling::td//a[contains(text(),'Delete')]")).click();
	}
	
}

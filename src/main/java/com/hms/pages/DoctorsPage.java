package com.hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class DoctorsPage extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Add A Doctor')]")
	WebElement AddADoctor_link;
	public static String modify_xpath1="//table//tr[5]//td/child::table//tr//td[contains(text(),'";
	public static String modify_xpath2="')]//following-sibling::td//a[contains(text(),'Modify')]";
			/*+ "babu')]//following-sibling::td//a[contains(text(),'Modify')]\r\n" + 
			"";*/
	public DoctorsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	public boolean AddADoctor_link() {
		return AddADoctor_link.isDisplayed();
	}
	
	public AddDoctorPage add_new_Doctor()
	{
		AddADoctor_link.click();
		return new AddDoctorPage();
	}
	public void modify_doctor_data(String name)
	{
		driver.findElement(By.xpath("//table//tr[5]//td/child::table//tr//td[contains(text(),'"+name+"')]//following-sibling::td//a[contains(text(),'Modify')]")).click();;
	}
	public void delete_doctor_data(String name)
	{
		driver.findElement(By.xpath("//table//tr[5]//td/child::table//tr//td[contains(text(),'"+name+"')]//following-sibling::td//a[contains(text(),'Delete')]")).click();;
	}

}

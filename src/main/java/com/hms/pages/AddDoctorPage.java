package com.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class AddDoctorPage extends TestBase {
	@FindBy(name = "name")
	WebElement doctorname;

	@FindBy(name = "spec")
	WebElement specialization;

	@FindBy(xpath = "//input[@type='submit' and @value='Submit']")
	WebElement submit_button;

	public AddDoctorPage() {
		PageFactory.initElements(driver, this);
	}

	public String verify_ADDNEWDoctor_pagetitle() {
		return driver.getTitle();
	}

	public boolean verify_submit_button() {
		return submit_button.isDisplayed();
	}

	public void create_doctor(String Doctor_name, String Doctor_specialization) {
		doctorname.sendKeys(Doctor_name);
		specialization.sendKeys(Doctor_specialization);
		submit_button.click();
																																																																																																																																																																																																																																																																																																																																																																																																															

	}

}

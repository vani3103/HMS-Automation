package com.hms.pages;

import org.openqa.selenium.support.PageFactory;

import com.hms.testbase.TestBase;

public class dummy extends TestBase {
public dummy()
{
	PageFactory.initElements(driver, this);
}
}

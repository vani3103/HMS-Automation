package com.hms.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hms.utilities.Loadtimes;
import com.hms.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/hms/config/config.properties");
		     try {
				prop.load(fis);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void initialization()
{
	String browsername=prop.getProperty("browser");
	if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty(prop.getProperty("chromedriver_key"), prop.getProperty("chromedriver_path"));
		/*ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");*/
		driver=new ChromeDriver();
	}
	else {
		driver=new FirefoxDriver();
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	

	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Loadtimes.implicitwait, TimeUnit.MILLISECONDS);
	driver.get(prop.getProperty("url"));
}
}

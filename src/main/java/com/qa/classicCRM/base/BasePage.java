package com.qa.classicCRM.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Bhawna
 *
 */
public class BasePage {

	// driver int
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	//ThreadLocal is a class that comng from java not from selenium, we are creating ThreadLOcal object and genercies with webDriver 

	/**
	 * This method is used to initialize the browser on the basis of given browser
	 * 
	 * @param browser
	 * @return This return WebDriver driver
	 */

	public WebDriver init_driver(String browser) {
		
		optionsManager = new OptionsManager(prop);
		
		System.out.println("Browser value is : " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// convert the string into boolean :- wrapper class:- parse boolean
			
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("safari")) {

			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser : " + browser);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return getDriver();
	}
	
	
		
	
		
	

	/**
	 * getDriver using ThreadLocal
	 * with this method whatever the drivers are  available just given to me. get method will return the webdriver
	 * static;- we can call it directly without creating the object
	 * synchroizes:- at a time they will pick only one test , one more thread is also available and one thread is also working 
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns properties prop reference
	 */

	public Properties init_prop() {
		// we have to read prop from config.prop file, we have to create the object of
		// properties file here
		// this properties will be used by another class too , then we will be declare
		// at the class level
		prop = new Properties();
		// we have to create the connection with this prop file , we need to create the
		// object of FileInputStream class
		// we have to tell them , where we have the properties file, we have to give the
		// path name
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Bhawna\\Selenium\\April2021POM\\src\\main\\java\\com\\qa\\classicCRM\\config\\config.properties");
			// we have to load the properties in this particular object
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}
	/**
	 * This method is used to take the screenshot It will return the path of
	 * screenshot
	 * take screenshot is interface and it is coming from selenium, we are casting this driver into screenshot and then
	 *  will give a method getScreenshotAs method and what type of screenshot method , you want to use:-  output type is file, i want to use
	 *  once the screenshot is taken it will return one file object 
	 * 
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}

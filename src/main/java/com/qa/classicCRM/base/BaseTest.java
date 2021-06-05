package com.qa.classicCRM.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.classicCRM.pages.AccountsPage;

import com.qa.classicCRM.pages.LoginPage;
import com.qa.classicCRM.pages.ProductsInfoPage;
import com.qa.classicCRM.pages.RegisterPage;

public class BaseTest {
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public AccountsPage accountsPage;
	public ProductsInfoPage productsInfoPage;
	public RegisterPage registerPage;
	
	
	@BeforeTest
	public void SetUp(){
		basepage = new BasePage();
		prop = basepage.init_prop();
		// this method returns you prop reference and store in the prop reference 
		String browser = prop.getProperty("browser"); // i want to read the prop from Properties file
		 driver = basepage.init_driver(browser); // this method returns you webDriver reference and gives you launch the browser
		 loginpage = new LoginPage(driver); // whenever we have to create the object of login page, we have to pass the driver
		 driver.get(prop.getProperty("url"));
		
		
	}
//	@AfterTest
//	public void tearDown() {
//		//driver.quit();
//	}

}

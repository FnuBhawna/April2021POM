package com.qa.classicCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.classicCRM.base.BasePage;
import com.qa.classicCRM.utilis.Constants;
import com.qa.classicCRM.utilis.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// all my pages are designed with encapculations
	// Frame is also a webelement

	// By locators OR
	private By emailId = By.id("input-email");
	private By passWord = By.id("input-password");;
	private By login = By.xpath("//input[@type='submit']");
	private By forgotpwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions:- Behavior of the page
	@Step("getting the Login Page Title...")
	public String getLoginPageTitle() {

		return elementUtil.waitfortitlePresents(Constants.LOGIN_PAGE_TITLE, 10);
	}
	@Step("Checking the forget Password Link is exist...")
	public boolean isForgotpwdLinkExist() {
//		 return driver.findElement(forgotpwdLink).isDisplayed();
		return elementUtil.doIsDisplayed(forgotpwdLink);
	}
	@Step("Log in with username : {0} and Password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Log in with : " + un + "and" + pwd);
		/*
		 * driver.findElement(emailId).sendKeys(un);
		 * driver.findElement(passWord).sendKeys(pwd);
		 * driver.findElement(login).click();
		 */
		elementUtil.sendKeys(emailId, un);
		elementUtil.sendKeys(passWord, pwd);
		elementUtil.doClick(login);

		return new AccountsPage(driver);

	}
@Step("navating to the Register Page")
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);

	}

}

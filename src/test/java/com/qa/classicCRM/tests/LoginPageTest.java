package com.qa.classicCRM.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.classicCRM.base.BaseTest;
import com.qa.classicCRM.testlisteners.ExtentReportListener;
import com.qa.classicCRM.utilis.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100: define ligin page features....")
@Story("US 101: define the log in page class features with title. forget password link and ligin functionality")
//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest {
	@Description("verify LoginPage Title Test")
	@Severity(SeverityLevel.NORMAL)

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();// inherit the properties from base test
		System.out.println("Login Page Title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Description("verify ForgetPasswordLink Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void verifyforgetPWLinkTest() {
		Assert.assertTrue(loginpage.isForgotpwdLinkExist());
	}

	@Description("verify Login Page Test with UserName and Password")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));

	}

}

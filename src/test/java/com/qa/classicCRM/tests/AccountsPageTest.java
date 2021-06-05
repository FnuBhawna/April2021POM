package com.qa.classicCRM.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.classicCRM.base.BaseTest;
import com.qa.classicCRM.utilis.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic-200: Design Accounts Page")
@Story("US-201: Designing the Accounts Page with title, header, accounts section and product results")

public class AccountsPageTest extends BaseTest {
	
	// Whenever you have to click on specific button or link navigating you to
	// different page or next page
	// that method responsibility to give you the that page class objects

	@BeforeClass
	public void AccountsPageSetUp() {
		accountsPage = loginpage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));

	}
	@Description("verify Accounts Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void AccountsPageTitleTest() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.Accounts_page_TITLE);

	}
	@Description("verify Accounts Page Header Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyAccountsPageHeaderTest() {
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("Accounts Page header is: " + headerValue);
		Assert.assertEquals(headerValue, Constants.Accounts_page_Header_Value);

	}
	@Description("verify Accounts Page count Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyMyAcccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.accountSectionsCount()== Constants.Accounts_sections_count);
	}
	@Description("verify Accounts Page List Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =4)
	public void verifyAccountSectionListTest() {
		accountsPage.getAccountSectionList();
		Assert.assertEquals(accountsPage.getAccountSectionList(), Constants.getAccountSectionList());
		}
	
	@Description("verify Accounts Page Search Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =5)
	public void searchTest() {
		Assert.assertTrue(accountsPage.doSearch("Mac Book"));
	}

}

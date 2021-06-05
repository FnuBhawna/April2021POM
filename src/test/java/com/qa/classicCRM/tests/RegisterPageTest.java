package com.qa.classicCRM.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.classicCRM.base.BaseTest;
import com.qa.classicCRM.utilis.Constants;
import com.qa.classicCRM.utilis.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerPageSetUp() {
		registerPage = loginpage.navigateToRegisterPage();

	}
	// data provider return type value is two dimn array and mapped this user reg test, according to the metrix, the data will be give to row wise to
		// userRegistration test, test nj will execute according to row wise . the test nj will execute according to row wise with the help of data provider
	@DataProvider // will call from excel util
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;

	}

	@Test(dataProvider ="getRegisterData") // this test case is getting the data from getRegister method
	public void userRegistrationTest(String firstNmae, String lastName, String email, String telephone, String password,
			 String subscribe) {
		registerPage.accountRegistartion( firstNmae,lastName, email,telephone, password,
			   subscribe);
	}

}

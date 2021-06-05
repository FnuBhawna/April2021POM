package com.qa.classicCRM.utilis;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	
	public static final String Accounts_page_TITLE = "My Account";
	
	public static final String Accounts_page_Header_Value = "Your Store";
	
	public static final int Accounts_sections_count = 4;
	
	public static final String REGISTER_SHEET_NAME = "Registration";
	
	public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created";
	
	
	public static List<String> getAccountSectionList() {
		List<String> accountlist = new ArrayList<String>();
		accountlist.add("My Account");
		accountlist.add("My Orders");
		accountlist.add("My Affiliate Account");
		accountlist.add("Newsletter");
		return accountlist;
		
	}

	
}

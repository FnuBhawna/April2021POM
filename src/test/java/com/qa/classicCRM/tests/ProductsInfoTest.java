package com.qa.classicCRM.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.classicCRM.base.BaseTest;

public class ProductsInfoTest extends BaseTest {

	@BeforeClass

	public void productinfoTest() {
		accountsPage = loginpage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));

	}
	/*
	 * {Brand=Apple, Availability=Out Of Stock, Price=$2,000.00, name=MacBook Pro,
	 * Product Code=Product Code, Reward Points=800, exTaxPrice=$2,000.00} PASSED:
	 * verifyProductInfoTest
	 * 
	 */

	@Test(enabled=false)
	public void productinfoPageTitleTest_iMac() {
		accountsPage.doSearch("iMac");
		productsInfoPage = accountsPage.selectProductFromResults("iMac");
		String title = productsInfoPage.getProductInfoTitle("iMac");
		System.out.println("title for imac : " + title);
		Assert.assertEquals(title, "iMac");
	}

	@Test(enabled=false)
	public void verifyProductInfoTest_MacBook() {
		String productName = "MacBook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productsInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productsInfoPage.getProductImages() == 4);
		Map<String, String> productInfoMap = productsInfoPage.getprodctInformation();
		System.out.println(productInfoMap);

		Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
		Assert.assertEquals(productInfoMap.get("exTaxPrice"), "$2,000.00");

		// it is not hard coded for this data

	}
	@Test
	public void verifyProductInfoTest_IMac() {
		String productName = "iMac";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productsInfoPage= accountsPage.selectProductFromResults(productName);
		Assert.assertTrue(productsInfoPage.getProductImages()==3);
		Map<String,String > productInfoMap = productsInfoPage.getprodctInformation();
		System.out.println(productInfoMap);
		
		Assert.assertEquals(productInfoMap.get("name"), productName);
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Price"), "$100.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		}

	@Test(priority = 2)
	public void selectQuantityTest() {
		productsInfoPage.selectQuantity("2");
		Assert.assertEquals("2", "2");

	}

	@Test(priority = 3)
	public void addToCartTest() {
		Assert.assertTrue(productsInfoPage.addToCart());
		
		

	}

}

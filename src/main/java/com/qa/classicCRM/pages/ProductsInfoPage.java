package com.qa.classicCRM.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.classicCRM.base.BasePage;
import com.qa.classicCRM.utilis.ElementUtil;

public class ProductsInfoPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementutil;

	private By productHeaderName = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By Quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector("ul.thumbnails li img");
    private By SuccessMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public ProductsInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}
	public String getProductInfoTitle(String productName) {
		return elementutil.waitfortitlePresents(productName, 15);
	}

	public Map<String, String> getprodctInformation() {

		Map<String, String> productinfoMap = new HashMap<>();

		productinfoMap.put("name", elementutil.doGetText(productHeaderName).trim());

		List<WebElement> productMetDataList = elementutil.getElements(productMetaData);
		for (WebElement e : productMetDataList) {
			productinfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}

		List<WebElement> productPriceList = elementutil.getElements(productPrice);
		productinfoMap.put("Price", productPriceList.get(0).getText().trim());
		productinfoMap.put("exTaxPrice", productPriceList.get(1).getText().split(":")[1].trim());
		return productinfoMap;
	}

	public void selectQuantity(String qty) {
		elementutil.clearText(Quantity);
		elementutil.sendKeys(Quantity, qty);
		

	}

	public boolean addToCart() {
		elementutil.doClick(addToCartButton);
		elementutil.doIsDisplayed(SuccessMessage);
		return true;
		
		
	}

	public int getProductImages() {
		int  imagesCount =  elementutil.getElements(productImages).size();
		System.out.println("Total images count : " + imagesCount );
		return imagesCount;
	}

}

package com.qa.classicCRM.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.classicCRM.base.BasePage;
import com.qa.classicCRM.utilis.Constants;
import com.qa.classicCRM.utilis.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Epic("Epic 200: Design Accounts Page")
@Story("US: 201: Designing the Accounts Page with title, header, accounts section and product results")
public class AccountsPage extends BasePage {
	private WebDriver driver ;
	private ElementUtil elementUtil;
	
	
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name ='search']");
	private By searchButton = By.cssSelector("div#search button[type ='button']");
	private By SearchitemResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems  = By.cssSelector(".product-thumb h4 a");
    


public AccountsPage(WebDriver driver) {
	this.driver = 	driver;
	elementUtil = new ElementUtil(this.driver);
	
}
@Step("getting Accounts Page Title")
public String getAccountPageTitle() {
	
	return elementUtil.waitfortitlePresents(Constants.Accounts_page_TITLE, 10);

	
}
@Step("getting the header value")
public String getHeaderValue() {
	
	
	if(elementUtil.doIsDisplayed(header)) {
		return elementUtil.doGetText(header);
	}
	return null;
}
@Step("getting Accounts Section Count")
public int accountSectionsCount() {
	return elementUtil.getElements(accountSectionHeaders).size(); 
	
}
@Step("getting Accounts Section List from my Accounts Page")
public List<String> getAccountSectionList() {
	List<String> accountsList = new ArrayList<String>();
	List<WebElement> accSectionList = elementUtil.getElements(accountSectionHeaders);
	for(WebElement e : accSectionList) {
		System.out.println(e.getText());
		accountsList.add(e.getText());
		
	}
	return accountsList;
}
@Step(" Searching a product with name : {0} ")
public boolean doSearch(String productName) {
	/*
	 * driver.findElement(searchText).sendKeys(productName);
	 * driver.findElement(searchButton).click();
	 */
	elementUtil.sendKeys(searchText, productName);
	elementUtil.doClick(searchButton);
	
	
	if(elementUtil.getElements(SearchitemResult).size()>0){
		return true;
	}
	return false;
	
}
@Step("SElecting a product with name drom results section  : {0}")
public ProductsInfoPage selectProductFromResults(String productName) {
	
	List<WebElement> resultitemList = elementUtil.getElements(resultItems);
	System.out.println("total mumber of items displayed" + resultitemList.size() );
	for(WebElement e : resultitemList ) {
		if(e.getText().equals(productName)) {
			e.click();
			break;
		}
	}
	return new ProductsInfoPage(driver);
}



}




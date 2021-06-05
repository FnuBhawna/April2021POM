package com.qa.classicCRM.utilis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to create the webElement on the basis of By locator
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("...Some exception occured while creating the webelement...");
			System.out.println(e.getMessage());
		}
		return element;
		// default value of WebElement or object = null
		// Local variable has to be initialized
		// if any exception is coming , it will become null
		// this method can be used anywhere

	}
	public List<WebElement>getElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	/**
	 * This method is used to click on element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("...Some exception occured while clicking on the webelement...");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This method is used to pass the value in a webelement This is the wrapper for
	 * send keys
	 * 
	 * @param locator
	 * @param value
	 */
	public void sendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("...Some exception occured while passing the value on the webelement...");
			System.out.println(e.getMessage());

		}
	}

	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element, value).perform();
	}

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.click(element).perform();
	}

	public WebElement waitforElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}
	// some elements should be presents in the DOM but not visisble on the screen
	// then we will use element to be clickable method,
	// it is taking some time to be displayed on the page
	// this is for click able elements

	public WebElement waitforElementclickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);

	}

	// Visibility means that the element is not only displayed but also has a height
	// and width that is greater than 0.
	public WebElement waitforElementVisible(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public WebElement waitforElementVisibleWithLocator(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator);

	}

	//
	public String waitforUrl(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
	}

	public boolean waitforAlerttoBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
	}

	public void ClickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();

	}

	public String waitfortitlePresents(String title, int timeout) {
		WebDriverWait wait1 = new WebDriverWait(driver, timeout);
		wait1.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public void visibilityofAlltheElements(List<WebElement> elements, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	public boolean doIsDisplayed(By locator) {
		return  getElement(locator).isDisplayed();
		
}
	
	public String  doGetText(By locator) {
		return getElement(locator).getText();
		
	}
	public void clearText(By locator) {
		getElement(locator).clear();
	}

}

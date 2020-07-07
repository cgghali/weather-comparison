package com.ghali.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ghali.automation.inferface.DriverInterface;

public class WebPageActions {

	protected static DriverInterface driverInterface;
	protected WebDriver driver;
	protected WebDriverWait wait;

	public WebPageActions(DriverInterface driverInterface) {

		this.driverInterface = driverInterface;
		this.driver = (WebDriver) this.driverInterface.getDriver();
		this.wait = new WebDriverWait(driver, 10);
	}

	public void navigateTo(String url) {

		// LOG.debug(String.format("Navigating to %s ", url));
		((WebDriver) this.driverInterface.getDriver()).get(url);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String keysToSend) {
		// Wait for element to be visible and then perform click
		element.clear();
		element.sendKeys(keysToSend);
	}

	public void simulateEnterKey() {
		Actions actions = new Actions((WebDriver) this.driverInterface.getDriver());
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void click_Text(String string) {
		WebElement webElement = driver.findElement(By.xpath(string));

		if (!(webElement.isSelected())) {
			driver.findElement(By.xpath(string)).click();
		}
	}
}

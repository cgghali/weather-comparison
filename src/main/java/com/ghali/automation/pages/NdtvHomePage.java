package com.ghali.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ghali.automation.actions.WebPageActions;
import com.ghali.automation.constants.Constants;
import com.ghali.automation.inferface.DriverInterface;

public class NdtvHomePage extends WebPageActions {

	public NdtvHomePage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}


	@FindBy(xpath = "//*[@id=\'h_sub_menu\']")
	private WebElement more;

	@FindBy(xpath = "//*[contains(text(),'WEATHER')]")
	private WebElement weather;

	public void gotoHome() {
		navigateTo(Constants.UrlConstants.NDTV_URL);
		clickElement(more);
		clickElement(weather);
	}
}

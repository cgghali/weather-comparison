package com.ghali.automation.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ghali.automation.inferface.DriverInterface;

public class LocalFirefoxDriver implements DriverInterface {
	// private final static Logger LOG = Logger.getLogger(LocalChromeDriver.class);
	private WebDriver driver;

	public LocalFirefoxDriver() {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Override
	public Object getDriver() {

		return this.driver;
	}

	@Override
	public void closeDriver() {

		this.driver.quit();
	}

}

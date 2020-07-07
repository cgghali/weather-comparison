package com.ghali.automation.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ghali.automation.inferface.DriverInterface;


public class LocalChromeDriver implements DriverInterface {
	// private final static Logger LOG = Logger.getLogger(LocalChromeDriver.class);
	private WebDriver driver;

	public LocalChromeDriver() {
		// LOG.trace("Launching the chromedriver");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
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

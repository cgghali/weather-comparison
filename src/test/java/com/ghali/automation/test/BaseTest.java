package com.ghali.automation.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ghali.automation.factory.DriverFactory;
import com.ghali.automation.factory.Pages;
import com.ghali.automation.factory.UtilityFactory;
import com.ghali.automation.inferface.DriverInterface;




public class BaseTest {

	public DriverInterface driverInterface;
	public Map<String, String> configMap = new ConcurrentHashMap<>();
	public Pages pages;
	private String driverName;

	@BeforeMethod
	public void BeforeTest() {
		configMap = UtilityFactory.getJavaUtils().getConfigMap();
		this.driverName = this.configMap.get("driverName");
		driverInterface = DriverFactory.getInstance(this.driverName).getDriverInterface();
		this.pages = new Pages(driverInterface);
	}

	@AfterMethod
	public void closeDriver() {
		driverInterface.closeDriver();
	}

}

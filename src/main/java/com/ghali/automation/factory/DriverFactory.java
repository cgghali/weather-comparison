package com.ghali.automation.factory;

import java.util.Locale;

import com.ghali.automation.constants.Constants;
import com.ghali.automation.drivers.LocalChromeDriver;
import com.ghali.automation.drivers.LocalFirefoxDriver;
import com.ghali.automation.inferface.DriverInterface;

public class DriverFactory {

	private DriverInterface driverInterface;
	private static DriverFactory instance;
	private String currentDriver;

	private DriverFactory(String driverName) {

		// LOG.debug("Launching the driver : " + driverName.toUpperCase());
		this.currentDriver = driverName;

		switch (this.currentDriver.toLowerCase(Locale.ENGLISH)) {

		case Constants.DriverNames.CHROME:
			this.driverInterface = new LocalChromeDriver();
			break;
		case Constants.DriverNames.FIREFOX:
			this.driverInterface = new LocalFirefoxDriver();
			break;

		default:
			// LOG.error(String.format("ERROR : Support for the %s driver is not available",
			// driverName));
			break;
		}
	}


	public static synchronized DriverFactory getInstance(String driverName) {

		instance = new DriverFactory(driverName);
		return instance;
	}


	public DriverInterface getDriverInterface() {

		return this.driverInterface;
	}

}

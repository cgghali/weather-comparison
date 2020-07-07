package com.ghali.automation.factory;



import com.ghali.automation.inferface.DriverInterface;
import com.ghali.automation.pages.NdtvHomePage;
import com.ghali.automation.pages.NdtvWeatherPage;


public class Pages {

	private final DriverInterface driverInterface;

	public Pages(DriverInterface driverInterface) {
		this.driverInterface = driverInterface;
	}

	public NdtvHomePage ndtvHomePage() {
		return new NdtvHomePage(this.driverInterface);
	}

	public NdtvWeatherPage ndtvWeatherPage() {
		return new NdtvWeatherPage(this.driverInterface);
	}

}

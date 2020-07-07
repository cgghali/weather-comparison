package com.ghali.automation.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ghali.automation.restapi.RestApiCalls;
import com.ghali.automation.utils.WeatherComparison;



public class SanityTest extends BaseTest {
	private static final Logger LOG = LoggerFactory.getLogger(SanityTest.class);

	@DataProvider(name = "city-provider1")
	public Object[][] dpMethodCity() {
		return new Object[][] { { "Bhopal" }, { "Bengaluru" } };
	}

	@Test(dataProvider = "city-provider1")

	void TestCity(String cityName) {
		this.pages.ndtvHomePage().gotoHome();
		Map<String, Float> tempreturAndHumidity = this.pages.ndtvWeatherPage().getWeatherDeatils(cityName);
		LOG.debug(String.format("Tempreture from NDTV Weather Page", tempreturAndHumidity.get("Temp")));
		LOG.debug(String.format("Humidity from NDTV Weather Page", tempreturAndHumidity.get("Humidity")));
		Map<Object, Object> responseMap = RestApiCalls.getWeatherDetails("Bangalore");
		LOG.debug(String.format("Tempreture from Rest API : %s", responseMap.get("temp")));
		LOG.debug(String.format("Tempreture from Rest API : %d", responseMap.get("humidity")));

		assertEquals(true, WeatherComparison.IsWeatherComparison(tempreturAndHumidity, responseMap),
				"Error: Results are Matching ");
	}

	@DataProvider(name = "city-provider2")
	public Object[][] dpMethodCitySate() {
		return new Object[][] { { "Bhopal", "Madhya Pradesh" }, { "Bengaluru", "Karnataka" } };
	}

	@Test(dataProvider = "city-provider2")
	void TestCityState(String cityName, String stateName) {
		this.pages.ndtvHomePage().gotoHome();
		Map<String, Float> tempreturAndHumidity = this.pages.ndtvWeatherPage().getWeatherDeatils(cityName);
		LOG.debug(String.format("Tempreture from NDTV Weather Page", tempreturAndHumidity.get("Temp")));
		LOG.debug(String.format("Humidity from NDTV Weather Page", tempreturAndHumidity.get("Humidity")));
		Map<Object, Object> responseMap = RestApiCalls.getWeatherDetails(cityName, stateName);
		LOG.debug(String.format("Tempreture from Rest API : %s", responseMap.get("temp")));
		LOG.debug(String.format("Tempreture from Rest API : %d", responseMap.get("humidity")));

		assertEquals(true, WeatherComparison.IsWeatherComparison(tempreturAndHumidity, responseMap),
				"Error: Results are Matching ");
	}

	@DataProvider(name = "city-provider3")
	public Object[][] dpMethodCityStatePin() {
		return new Object[][] { { "Bhopal", "Madhya Pradesh", "462001" }, { "Bengaluru", "Karnataka", "560001" } };
	}

	@Test(dataProvider = "city-provider3")
	void TestCitySatatePincode(String cityName, String stateName, String pinCode) {
		this.pages.ndtvHomePage().gotoHome();
		Map<String, Float> tempreturAndHumidity = this.pages.ndtvWeatherPage().getWeatherDeatils(cityName);
		LOG.debug(String.format("Tempreture from NDTV Weather Page", tempreturAndHumidity.get("Temp")));
		LOG.debug(String.format("Humidity from NDTV Weather Page", tempreturAndHumidity.get("Humidity")));
		Map<Object, Object> responseMap = RestApiCalls.getWeatherDetails(cityName, stateName, pinCode);
		LOG.debug(String.format("Tempreture from Rest API : %s", responseMap.get("temp")));
		LOG.debug(String.format("Tempreture from Rest API : %d", responseMap.get("humidity")));

		assertEquals(true, WeatherComparison.IsWeatherComparison(tempreturAndHumidity, responseMap),
				"Error: Results are Matching ");
	}


}

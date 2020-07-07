package com.ghali.automation.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ghali.automation.actions.WebPageActions;
import com.ghali.automation.inferface.DriverInterface;

public class NdtvWeatherPage extends WebPageActions {

	public NdtvWeatherPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}

	private Map<String, Float> weatherDetailsWebMap = new HashMap<String, Float>();
	private static final String USER_XPATH = "//*[@id=\'%s\']";
	private static final String CITY_SELECTOR_MAP = "//*[@id=\"map_canvas\"]//div[contains(@class, 'cityText') and text()='%s']";

	@FindBy(xpath = "//*[@id='searchBox']")
	private WebElement SearchCity;

	@FindBy(xpath = "//*[@id=\'map_canvas\']")
	WebElement mapCanvas;

	@FindBy(xpath = "//*[@id='map_canvas']//div[contains(@class,'leaflet-popup-content-wrapper')]/div/div/span[contains(@class,'heading')]/following-sibling::span/following-sibling::span/b")
	WebElement humidity;

	@FindBy(xpath = "//*[@id='map_canvas']//div[contains(@class,'leaflet-popup-content-wrapper')]/div/div/span[contains(@class,'heading')]/following-sibling::span/following-sibling::span/following-sibling::span/b")
	WebElement tempDeg;

	@FindBy(xpath = "//*[@id='map_canvas']//div[contains(@class,'leaflet-popup-content-wrapper')]/div/div/span[contains(@class,'heading')]/following-sibling::span/following-sibling::span/following-sibling::span/following-sibling::span/b")
	WebElement tempFah;

	public Map<String, Float> getWeatherDeatils(String cityName) {
		String fullXpath = String.format(USER_XPATH, cityName);
		String path = String.format(CITY_SELECTOR_MAP, cityName);

		// Search city
		enterText(SearchCity, cityName);
		simulateEnterKey();

		click_Text(fullXpath);
		click_Text(path);

		weatherDetailsWebMap.put("Humidity", getHumidity());
		weatherDetailsWebMap.put("Temp", getTempretureDeg());
		return weatherDetailsWebMap;
	}

	public float getHumidity() {
		String tempString;
		tempString = humidity.getText();
		String[] str = tempString.split(":");
		return (Float.parseFloat(str[1].substring(0, str[1].length() - 1)));

	}

	public float getTempretureDeg() {
		String tempHumidity;
		tempHumidity = tempDeg.getText();
		String[] str = tempHumidity.split(":");
		return (Float.parseFloat(str[1].trim()));

	}
}

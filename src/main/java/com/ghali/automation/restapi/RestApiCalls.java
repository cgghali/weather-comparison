package com.ghali.automation.restapi;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghali.automation.constants.Constants;
import com.jayway.restassured.response.Response;

public class RestApiCalls {

	public static Map<Object, Object> getWeatherDetails(String cityName) {

		final Logger LOG = LoggerFactory.getLogger(RestApiCalls.class);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();

		Response response;
		final String API_KEY = "7fe67bf08c80ded756e598d6f8fedaea";
		String restAPIUrl = Constants.WeatherApiEndpoints.BASE_URL + cityName + "&" + "appid=" + API_KEY;

		LOG.debug(String.format("Performing the get weather call on api :%s", restAPIUrl));
		response = given().get(restAPIUrl);

		LOG.debug(
				String.format("Get call on url %s took %s seconds", restAPIUrl, response.getTimeIn(TimeUnit.SECONDS)));
		responseMap = response.jsonPath().getMap("main");

		return responseMap;

	}


	public static Map<Object, Object> getWeatherDetails(String cityName, String stateName) {
		final Logger LOG = LoggerFactory.getLogger(RestApiCalls.class);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();

		Response response;
		final String API_KEY = "7fe67bf08c80ded756e598d6f8fedaea";
		String restAPIUrl = Constants.WeatherApiEndpoints.BASE_URL + cityName + "," + stateName + "&" + "appid="
				+ API_KEY;

		LOG.debug(String.format("Performing the get weather call on api :%s", restAPIUrl));
		response = given().get(restAPIUrl);

		LOG.debug(
				String.format("Get call on url %s took %s seconds", restAPIUrl, response.getTimeIn(TimeUnit.SECONDS)));
		responseMap = response.jsonPath().getMap("main");

		return responseMap;

	}

	public static Map<Object, Object> getWeatherDetails(String cityName, String stateName, String pinCode) {
		final Logger LOG = LoggerFactory.getLogger(RestApiCalls.class);
		Map<Object, Object> responseMap = new HashMap<Object, Object>();

		Response response;
		final String API_KEY = "7fe67bf08c80ded756e598d6f8fedaea";
		String restAPIUrl = Constants.WeatherApiEndpoints.BASE_URL+ cityName + "," + stateName + "," + pinCode +"&" + "appid=" + API_KEY;

		LOG.debug(String.format("Performing the get weather call on api :%s", restAPIUrl));
		response = given().get(restAPIUrl);

		LOG.debug(
				String.format("Get call on url %s took %s seconds", restAPIUrl, response.getTimeIn(TimeUnit.SECONDS)));
		responseMap = response.jsonPath().getMap("main");

		return responseMap;
	}
}
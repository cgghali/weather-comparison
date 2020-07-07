package com.ghali.automation.utils;

import java.util.Map;

import com.ghali.automation.factory.UtilityFactory;

public class WeatherComparison {

	static float tempretureWeb;
	static float humidWeb;
	static float tempretureApi;
	static float humidApi;

	static float tempretureVariance = Float
			.parseFloat(UtilityFactory.getJavaUtils().getConfigMap().get("tempretureVariance"));
	static float humidVariance = Float.parseFloat(UtilityFactory.getJavaUtils().getConfigMap().get("humidityVariance"));

	public static boolean IsWeatherComparison(Map<String, Float> responseWeb, Map<Object, Object> responseApi) {
		tempretureWeb = responseWeb.get("Temp");
		humidWeb = responseWeb.get("Humidity");

		tempretureApi = (float) responseApi.get("temp") - 273.15F;
		humidApi = (int) (responseApi.get("humidity"));

		if (((humidApi == humidWeb) && (tempretureApi == tempretureWeb))
				|| ((humidApi - humidWeb <= humidVariance)
				&& (tempretureApi - tempretureWeb <= tempretureVariance))) {
			return true;
		}
		return false;
	}

}


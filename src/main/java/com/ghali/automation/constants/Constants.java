package com.ghali.automation.constants;

public class Constants {

	public static final class DriverNames {

		private DriverNames() {
		}

		public static final String ANDROID = "android";
		public static final String IOS = "ios";
		public static final String FIREFOX = "firefox";
		public static final String CHROME = "chrome";
		public static final String SAFARI = "safari";
		public static final String IE = "internet explorer";
		public static final String EDGE = "ms edge";
	}

	public static final class UrlConstants {

		private UrlConstants() {
		}

		// TOXY RELATED URLS
		public static final String NDTV_URL = "http://www.ndtv.com";
	}

	public static final class WeatherApiEndpoints {

		private WeatherApiEndpoints() {

		}

		private static final String DOMAIN = "api.openweathermap.org";
		private static final String VERSION = "2.5";
		public static final String BASE_URL = "https://" + DOMAIN + "/data/" + VERSION + "/weather?q=";
	}

	public final class MessagesConstants {

		private MessagesConstants() {
		}

		public static final String WAS_NOT_LOADED = " was not loaded...";

	}

	public static final class GenericConstants {

		public static final String ROOT;
		public static final String HOME;

		static {
			ROOT = System.getProperty("user.dir");
			HOME = System.getProperty("user.home");
		}

		private GenericConstants() {
		}

		public static final String CONFIG_PROPERTIES = ROOT + "/Config.properties";

	}

}

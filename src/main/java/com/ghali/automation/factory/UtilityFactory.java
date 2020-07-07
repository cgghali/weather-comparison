package com.ghali.automation.factory;

import com.ghali.automation.utils.JavaUtils;

public class UtilityFactory {

	private static JavaUtils javaUtils;

	public static JavaUtils getJavaUtils() {

		if (javaUtils == null) {
			javaUtils = new JavaUtils();
		}
		return javaUtils;
	}

}

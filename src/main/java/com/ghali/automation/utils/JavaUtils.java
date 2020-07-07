package com.ghali.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ghali.automation.constants.Constants;
import com.ghali.automation.constants.Constants.GenericConstants;

import junit.framework.Assert;

public class JavaUtils {
	// private final static Logger LOG = Logger.getLogger(JavaUtils.class);
	private static final Logger LOG = LoggerFactory.getLogger(JavaUtils.class);
	private Map<String, String> configMap = new ConcurrentHashMap<>();

	public JavaUtils() {
	}

	/**
	 * Returns Map of properties.
	 *
	 * @param String
	 *
	 */
	public Map<String, String> readPropertiesFile(String filePath) {

		LOG.debug("Reading file at location : " + filePath);
		FileInputStream in = null;
		Map<String, String> configMap = new ConcurrentHashMap<String, String>();
		try {
			in = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(in);

			for (String key : prop.stringPropertyNames()) {
				final String value = prop.getProperty(key);
				configMap.put(key, value);
			}
		} catch (final FileNotFoundException err) {
			LOG.error(err.getMessage());
			Assert.fail(filePath + Constants.MessagesConstants.WAS_NOT_LOADED);
		} catch (final IOException exn) {
			LOG.error(exn.getMessage());
			Assert.fail(filePath + Constants.MessagesConstants.WAS_NOT_LOADED);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}

		return configMap;
	}

	public Map<String, String> getConfigMap() {

		if (this.configMap.isEmpty()) {
			LOG.debug("Reading the property file at location : " + GenericConstants.CONFIG_PROPERTIES);
			this.configMap = this.readPropertiesFile(GenericConstants.CONFIG_PROPERTIES);
		}
		return this.configMap;
	}

	public void sleep(long timeInMillis) {

		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LOG.error("ERROR : Could not execute sleep on this thread");
		}
	}

}

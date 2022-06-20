package com.java.webc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtil {

	public static String refineInput(String input) {

		String refindCommand = input.trim();
		return refindCommand = refindCommand.replaceAll("\\s+", " ");
	}

	public static Logger getLogger(Class loggerClass) {
		return LoggerFactory.getLogger(loggerClass);
	}

}

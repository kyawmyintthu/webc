package com.java.webc.util;

import org.apache.commons.validator.routines.UrlValidator;

public class ValidatorUtil {

	public static boolean urlValidator(String url) {
		UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid(url);
	}

}

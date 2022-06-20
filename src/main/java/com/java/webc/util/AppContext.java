package com.java.webc.util;

import java.util.ArrayList;
import java.util.List;

public class AppContext {
	
	public static final String REQUEST_INPUT_URL = "Please enter url : ";
	public static final String THANKS = "Thank you !!!";
	public static final String PROCESS_INSTRUCTION = "1 : To view constructed link \n2 : To search keywords \n3 : To re-input the link \n99 : To exit";
	public static final String REQUEST_INPUT_INSTRUCTION = "Please input instruction number : ";
	public static final String REQUEST_INPUT_SEARCH_WORD = "Please input you want to search : ";
	public static final String FAIL_TO_LOAD_CONSOLE = "Fail to load console!";
	public static final String URL_FORMAT_NOT_CORRECT= "Input URL is not correct format.";
	public static List<String> dataList = new ArrayList<String>();
	public static Boolean isVisited = false;
	public static final String EXIT_FROM_SYSTEM = "99";
	public static final String SEARCH_LINK_INSTRUCTION = "2";
	public static final String SHOW_LINK_INSTRUCTION = "1";
	public static final String REINPUT_LINK_INSTRUCTION = "3";
	
	public static List<String> getDataList() {
		return dataList;
	}
	
}

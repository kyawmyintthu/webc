package com.java.webc;

import java.io.Console;

import org.apache.commons.lang3.StringUtils;

import com.java.webc.service.CawlerService;
import com.java.webc.service.CawlerServiceImpl;
import com.java.webc.util.AppContext;
import com.java.webc.util.AppUtil;
import com.java.webc.util.ValidatorUtil;

public class EntryPoint {

	public static void main(String[] args) {
		AppUtil.getLogger(EntryPoint.class).info("Start of Webc process ...");
		Console console = System.console();

		if (console == null) {
			System.out.println(AppContext.FAIL_TO_LOAD_CONSOLE);
		}

		boolean isContinue = true;
		boolean isFirst = true;
		String command = "";

		while (isContinue) {

			if (isFirst) {
				command = console.readLine(AppContext.REQUEST_INPUT_URL, args);
				System.out.println("");
				isFirst = false;
			} else {
				System.out.println("");
				System.out.println(AppContext.PROCESS_INSTRUCTION);
				command = console.readLine(AppContext.REQUEST_INPUT_INSTRUCTION, args);
			}
			if (!StringUtils.isBlank(command)) {
				CawlerService cs = new CawlerServiceImpl();
				command = AppUtil.refineInput(command);

				AppUtil.getLogger(EntryPoint.class).info("instruction : " + command);

				if (AppContext.EXIT_FROM_SYSTEM.equals(command)) {
					System.out.println(AppContext.THANKS);
					AppUtil.getLogger(EntryPoint.class).info("End process ...");
					System.exit(0);

				} else if (AppContext.SHOW_LINK_INSTRUCTION.equals(command)) {
					AppUtil.getLogger(EntryPoint.class).info("Search process ...");
					cs.showDataLink();

				} else if (AppContext.SEARCH_LINK_INSTRUCTION.equals(command)) {
					command = console.readLine(AppContext.REQUEST_INPUT_SEARCH_WORD, args);
					command = AppUtil.refineInput(command);
					cs.searchByWord(command);

				} else if (AppContext.REINPUT_LINK_INSTRUCTION.equals(command)) {
					AppUtil.getLogger(EntryPoint.class).info("Link re-constraction process ...");
					AppContext.dataList.clear();
					command = console.readLine(AppContext.REQUEST_INPUT_URL, args);
					command = AppUtil.refineInput(command);

					if (ValidatorUtil.urlValidator(command)) {
						cs.constractDataLink(command);
					} else {
						System.out.println(AppContext.URL_FORMAT_NOT_CORRECT);
						isFirst = true;
					}
				} else {
					AppUtil.getLogger(EntryPoint.class).info("Link constraction process ...");
					if (ValidatorUtil.urlValidator(command)) {
						cs.constractDataLink(command);
					} else {
						System.out.println(AppContext.URL_FORMAT_NOT_CORRECT);
						isFirst = true;
					}
				}

			}
		}

	}

}

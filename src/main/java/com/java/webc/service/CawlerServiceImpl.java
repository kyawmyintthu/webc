package com.java.webc.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.java.webc.util.AppContext;
import com.java.webc.util.AppUtil;

public class CawlerServiceImpl implements CawlerService {

	@Override
	public void constractDataLink(String url) {

		List<String> dataList = AppContext.getDataList();
		System.out.print("loading link");
		constract(url, dataList);
		int size = dataList.size();
		if (size > 0) {
			System.out.println("Loading completed.");
			AppUtil.getLogger(CawlerServiceImpl.class).info("Loading completed and data size : " + size);
		} else {
			System.out.println("The input link are not accessable.");
			AppUtil.getLogger(CawlerServiceImpl.class).info("The input link are not accessable.");
		}
	}

	private void constract(String url, List<String> dataList) {
		System.out.print("*");
		Document document;
		try {
			document = Jsoup.connect(url).get();
			if (document != null) {
				dataList.add(url);

				Elements linkElements = document.select("a[href]");

				for (Element le : linkElements) {
					String link = le.attr("abs:href");

					try {
						new URL(link).toURI();
						if (dataList.size() > 200) {
							break;
						} else if (!dataList.contains(link)) {
							constract(link, dataList);
						}
					} catch (MalformedURLException | URISyntaxException e) {
						AppUtil.getLogger(CawlerServiceImpl.class).warn(e.getMessage());
					}
				}
			}

		} catch (IOException e) {
			AppUtil.getLogger(CawlerServiceImpl.class).error(e.getMessage());
		}
	}

	@Override
	public void showDataLink() {
		AppContext.getDataList().parallelStream().forEach(System.out::println);

	}

	@Override
	public void searchByWord(String searchWord) {
		System.out.println("Searching by " + searchWord);
		AppUtil.getLogger(CawlerServiceImpl.class).info(("Searching by " + searchWord));

		List<String> filterList = AppContext.getDataList().parallelStream()
				.filter(l -> l.toLowerCase().contains(searchWord.toLowerCase())).collect(Collectors.toList());
		int size = filterList.size();

		if (size > 0) {
			filterList.parallelStream().forEach(System.out::println);
			System.out.println("Total links found : " + size);
			AppUtil.getLogger(CawlerServiceImpl.class).info("Total links found : " + size);
		} else {
			System.out.println("Search word does not exit in constructed link.");
			AppUtil.getLogger(CawlerServiceImpl.class).info("Search word does not exit in constructed link.");
		}
	}

}

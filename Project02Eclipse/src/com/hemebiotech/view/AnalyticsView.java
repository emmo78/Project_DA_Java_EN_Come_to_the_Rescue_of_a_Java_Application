package com.hemebiotech.view;

import java.util.List;

/**
 * View all occurencies
 * and exception message
 * @author olivier MOREL
 *
 */
public class AnalyticsView {
	
	public void showListedOccurencies(List<String> listOfOccurencies) {
		listOfOccurencies.forEach(occString -> System.out.print(occString));
	}
	
	public void showExceptionMessage(String message) {
		System.out.print(message);
	}
}

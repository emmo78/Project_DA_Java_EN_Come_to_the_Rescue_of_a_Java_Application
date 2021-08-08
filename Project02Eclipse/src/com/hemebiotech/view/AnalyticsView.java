package com.hemebiotech.view;

import java.util.List;

/**
 * View all occurencies
 * @author olivier MOREL
 *
 */
public class AnalyticsView {
	public void printExceptionThrowed(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}
	
	public void showListedOccurencies(List<String> listOfOccurencies) {
		listOfOccurencies.stream().forEach(occString -> System.out.println(occString));
	}
}

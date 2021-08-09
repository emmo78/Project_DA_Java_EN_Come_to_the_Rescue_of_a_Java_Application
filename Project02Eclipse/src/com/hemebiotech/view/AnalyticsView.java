package com.hemebiotech.view;

import java.util.List;

/**
 * View all occurencies
 * @author olivier MOREL
 *
 */
public class AnalyticsView {
	
	public void showListedOccurencies(List<String> listOfOccurencies) {
		listOfOccurencies.forEach(occString -> System.out.println(occString));
	}
}

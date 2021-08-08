package com.hemebiotech.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.hemebiotech.dao.ISymptomReader;
import com.hemebiotech.dao.ReadSymptomDataFromFile;
import com.hemebiotech.model.Occurence;
import com.hemebiotech.view.AnalyticsView;

/**
 * Controller
 * 
 * This is a singleton, only one instance possible.
 * 
 * @author olivier MOREL
 *
 */

public final class AnalyticsController {
	/**
	 * instance is private to exercise access control
	 */
	private static AnalyticsController instance;
	private AnalyticsView analyticsViewer = new AnalyticsView();

	private AnalyticsController() {
	}

	/**
	 * Getter Static to get it without instantiating it
	 * 
	 * @return the only one AnalyticsController()'s instance
	 */
	public static AnalyticsController getInstance() {
		if (instance == null) {
			instance = new AnalyticsController();
		}
		return instance;
	}

	public void run() {
		ISymptomReader reader = null;
		List<String> symptomsList = null;
		final String userDir = System.getProperty("user.dir");
		final String filePath = userDir + "/Project02Eclipse/symptoms.txt";

		reader = new ReadSymptomDataFromFile(filePath);

		if (reader == null)
			System.exit(-1);

		symptomsList = reader.getSymptoms();

		if (symptomsList == null) {
			reader.close();
			System.exit(-1);
		}

		analyticsViewer.showListedOccurencies(symptomsList);

	}
}
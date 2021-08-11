package com.hemebiotech.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.hemebiotech.dao.ISymptomIO;
import com.hemebiotech.dao.SymptomReadDataFromFile;
import com.hemebiotech.dao.SymptomWriteDataToFile;
import com.hemebiotech.model.Occurence;
import com.hemebiotech.model.Symptom;
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
	private AnalyticsView analyticsViewer;
	private StringBuilder exceptionMessage;// Declare a pointer to the object

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

	/**
	 * Contains controller logic
	 */
	public void run() {
		analyticsViewer = new AnalyticsView();
		exceptionMessage = new StringBuilder();// The pointer is initialized with the address of the object
		ISymptomIO ioFile = null;
		List<String> symptomsList = null;
		List<Occurence> symptomsFreqList = new ArrayList<>();
		final String userDir = System.getProperty("user.dir");
		final String path = userDir + "/Project02Eclipse/";
		final String fileToRead = "symptoms.txt";
		final String fileToWrite = "result.out";
		Iterator<String> iteratorSymptomsList;
		Occurence oldSymptom = null;
		Occurence newSymptom = null;

		// Begin reading data from file
		ioFile = new SymptomReadDataFromFile(path + fileToRead, exceptionMessage);// The pointer is transmitted and will not change
		isExceptionOccur();// Test if the object pointed by exceptionMessage was modified

		symptomsList = ioFile.getSymptoms(exceptionMessage);
		ioFile.close(exceptionMessage);
		isExceptionOccur();

		symptomsList.sort(null); // Sort list in alpphabetical order

		// Begin enumerating and create each symptom with their frequency
		iteratorSymptomsList = symptomsList.iterator();
		if (iteratorSymptomsList.hasNext())
			oldSymptom = new Symptom(iteratorSymptomsList.next());
		while (iteratorSymptomsList.hasNext()) {
			newSymptom = new Symptom(iteratorSymptomsList.next());
			if (newSymptom.equals(oldSymptom)) {
				oldSymptom.incrementNumber();
			} else {
				symptomsFreqList.add(oldSymptom);
				oldSymptom = newSymptom;
			}
		}
		symptomsFreqList.add(oldSymptom);

		// Show result
		try {
			analyticsViewer.showListedOccurencies(
					symptomsFreqList.stream().map(occ -> occ.toString()).collect(Collectors.toList()));
		} catch (NullPointerException e) {
			analyticsViewer.showExceptionMessage("No Data in File");
			System.exit(0);
		}

		// Begin writing data into a file
		ioFile = new SymptomWriteDataToFile(path + fileToWrite, exceptionMessage);
		isExceptionOccur();

		ioFile.writeSymptoms(symptomsFreqList, exceptionMessage);
		ioFile.close(exceptionMessage);
		isExceptionOccur();
	}

	/**
	 * Test if the object pointed by the pointer is modified (contains an exception
	 * message)
	 */
	private void isExceptionOccur() {
		if (exceptionMessage.length() != 0) {
			analyticsViewer.showExceptionMessage(exceptionMessage.toString());
			System.exit(-1);
		}
	}
}
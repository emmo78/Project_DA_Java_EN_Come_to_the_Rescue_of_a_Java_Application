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
		analyticsViewer = new AnalyticsView();
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

		ioFile = new SymptomReadDataFromFile(path + fileToRead); //Start bloc code to read data from file

		if (ioFile == null)
			System.exit(-1);

		symptomsList = ioFile.getSymptoms();
		ioFile.close();

		if (symptomsList == null)
			System.exit(-1);
		
		symptomsList.sort(null); //Start bloc code to sort list into a set of symptoms with their frequencies

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

		try {
			analyticsViewer.showListedOccurencies(
				symptomsFreqList.stream().map(occ -> occ.toString()).collect(Collectors.toList())); //show result
		} catch (NullPointerException e) {
			analyticsViewer.showExceptionMessage("No Data in File");
			System.exit(0);
		}	

		ioFile = new SymptomWriteDataToFile(path + fileToWrite); //Start bloc code to write data into a file

		if (ioFile == null)
			System.exit(-1);

		if (ioFile.writeSymptoms(symptomsFreqList) == false)
			System.exit(-1);

		ioFile.close();
	}
}
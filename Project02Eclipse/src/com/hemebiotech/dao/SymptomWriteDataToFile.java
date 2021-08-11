package com.hemebiotech.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.hemebiotech.model.Occurence;

/**
 * Write data from file into list implementation Close properly File reader
 *
 */
public class SymptomWriteDataToFile implements ISymptomIO {

	private FileWriter fileWriter;

	/** 
	 * Construtor
	 * @param filePath is a full or partial path to file with symptom strings in it, one per line
	 * @param exceptionMessage is the pointer to the object to handle exception message                 
	 */
	public SymptomWriteDataToFile(String filePath, StringBuilder exceptionMessage) {
		try {
			fileWriter = new FileWriter(filePath);
		} catch (IOException e) {
			exceptionMessage.append(e.getMessage());
		}
	}

	@Override
	public void close(StringBuilder exceptionMessage) {
		try {
			fileWriter.close();
		} catch (IOException e) {
			exceptionMessage.append(e.getMessage());
		}
	}

	@Override
	public List<String> getSymptoms(StringBuilder exceptionMessage) {
		return null;
	}

	@Override
	public void writeSymptoms(List<Occurence> listOfOcc, StringBuilder exceptionMessage) {
		for (Occurence occ : listOfOcc) {
			try {
				fileWriter.write(occ.toString());
			} catch (IOException e) {
				exceptionMessage.append(e.getMessage());
			}
		}
	}
}

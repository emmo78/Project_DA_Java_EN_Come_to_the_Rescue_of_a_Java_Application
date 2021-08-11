package com.hemebiotech.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.model.Occurence;

/**
 * Read data from file into list implementation
 * Close properly File reader
 * @author olivier MOREL
 */
public class SymptomReadDataFromFile implements ISymptomIO {

	private FileReader fileReader;

	/** 
	 * Construtor
	 * @param filePath a full or partial path to file with symptom strings in it, one per line
	 * @param exceptionMessage is the pointer to the object to handle exception message                 
	 */
	public SymptomReadDataFromFile(String filePath, StringBuilder exceptionMessage) {
		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			exceptionMessage.append(e.getMessage()); //the  object is modified not the value of pointer
		}
	}

	@Override
	public void close(StringBuilder exceptionMessage) {
		try {
			fileReader.close();
		} catch (IOException e) {
			exceptionMessage.append(e.getMessage());
		}
	}

	@Override
	public List<String> getSymptoms(StringBuilder exceptionMessage) {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader buffReader = new BufferedReader(fileReader);
		String line;

		try {
			line = buffReader.readLine();
			while (line != null) {
				result.add(line);
				line = buffReader.readLine();
			}
			buffReader.close();
		} catch (IOException e) {
			exceptionMessage.append(e.getMessage());
		}
		return result;
	}

	@Override
	public void writeSymptoms(List<Occurence> listOfOcc, StringBuilder exceptionMessage) {
	}
}

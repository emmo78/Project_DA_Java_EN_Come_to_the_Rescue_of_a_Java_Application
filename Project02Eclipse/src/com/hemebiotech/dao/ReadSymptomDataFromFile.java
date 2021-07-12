package com.hemebiotech.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private FileReader fileReader;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * @throws FileNotFoundException
	 */
	public ReadSymptomDataFromFile(String filePath) {
		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getSymptoms() {
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
			e.printStackTrace();
			result=null;
		}

		return result;
	}

}

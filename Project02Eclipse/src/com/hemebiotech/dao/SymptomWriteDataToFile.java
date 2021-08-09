package com.hemebiotech.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.model.Occurence;

/**
 * Write data from file into list implementation
 * Close properly File reader
 *
 */
public class SymptomWriteDataToFile implements ISymptomIO {

	private FileWriter fileWriter;

	/**
	 * 
	 * @param filepath a full or partial path to file to Write
	 */
	public SymptomWriteDataToFile(String filePath) {
		try {
			fileWriter = new FileWriter(filePath);
		} catch (IOException e) {
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

	@Override
	public boolean writeSymptoms(List<Occurence> listOfOcc) {
		// TODO Auto-generated method stub
		return false;
	}

}

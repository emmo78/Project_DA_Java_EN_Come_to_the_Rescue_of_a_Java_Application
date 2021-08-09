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
 * Write data from file into list implementation Close properly File reader
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
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getSymptoms() {
		return null;
	}

	@Override
	public boolean writeSymptoms(List<Occurence> listOfOcc) {
		boolean succes = true;

		for (Occurence occ : listOfOcc) {
			try {
				fileWriter.write(occ.toString());
			} catch (IOException e) {
				e.printStackTrace();
				succes = false;
			}
		}
		return succes;
	}

}

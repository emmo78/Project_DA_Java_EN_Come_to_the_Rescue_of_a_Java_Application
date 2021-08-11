package com.hemebiotech.dao;

import java.util.List;

import com.hemebiotech.model.Occurence;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomIO {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @param exceptionMessage is the pointer to the StrigBuilder object
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms(StringBuilder exceptionMessage);
	
	/**
	 * Write Occurence into a file.
	 * 
	 * @param listOfOcc is a List containing Occurence objects
	 * @param exceptionMessage is the pointer to the StrigBuilder object
	 */
	void writeSymptoms(List<Occurence> listOfOcc, StringBuilder exceptionMessage);

	/**
	 * To close FileIO's instancce properly
	 * @param exceptionMessage is the pointer to the object to handle exception message                 
	 */
	void close(StringBuilder exceptionMessage);
}

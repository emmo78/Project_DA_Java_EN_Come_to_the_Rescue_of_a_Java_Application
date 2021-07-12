package com.hemebiotech.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public abstract class Occurencies {
	private Map<String, Integer> occurencies;
	private String name;
	private int frequency;

	/**
	 * Construtor
	 * @return HashMap<String, Integer>
	 */
	public abstract Map<String, Integer> Occurencies();

	/**
	 * @return the occurencies
	 */
	public abstract Map<String, Integer> getOccurencies();
	

	/**
	 * @param occurencies the occurencies to set
	 */
	public abstract void setOccurencies(Map<String, Integer> occurencies);
	

	/**
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @param name the name to set
	 */
	public abstract void setName(String name);


	/**
	 * @return the frequency
	 */
	public abstract int getFrequency();

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return Returns HashSet<String>
	 * the occurrences with their frequency
	 */
	public abstract Set<String> listOccurenciesWithFrequencies();
}

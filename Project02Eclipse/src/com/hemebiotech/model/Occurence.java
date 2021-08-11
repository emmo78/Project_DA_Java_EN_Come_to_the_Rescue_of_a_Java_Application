package com.hemebiotech.model;

/**
 * Occurence model
 * 
 * @author Olivier MOREL
 */
public abstract class Occurence {

	/**
	 * Fields are protected to get access from child either in package or not
	 */
	protected String name;
	protected int number;

	/**
	 * @return the number
	 */
	public abstract int getNumber();

	/**
	 *  increment number by 1
	 */
	public abstract void incrementNumber();

	/**
	 * Test if name is equal case insensitive
	 * @param occ is the object which name to test
	 * @return true if the name are equals, false if not 
	 */
	public abstract boolean equals(Occurence occ);

	/**
	 * @return a String  with the name and the number of an occurence
	 */
	public abstract String toString();
}

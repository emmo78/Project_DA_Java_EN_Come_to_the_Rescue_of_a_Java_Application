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
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @param name the name to set
	 */
	public abstract void setName(String name);

	/**
	 * @return the number
	 */
	public abstract int getNumber();

	/**
	 * @param number the number to set
	 */
	public abstract void setNumber(int number);

	/**
	 * Test if name is equal case insensitive
	 * @param occ
	 * @return boolean
	 */
	public abstract boolean equals(Occurence occ);

	/**
	 * @return a String  with the name and the number of an occurence
	 */
	public abstract String toString();
}

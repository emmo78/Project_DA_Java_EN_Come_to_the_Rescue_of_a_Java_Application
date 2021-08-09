package com.hemebiotech.model;

public class Symptom extends Occurence {

	public Symptom(String name) {
		this.name = name.toLowerCase();
		this.number = 1;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void incrementNumber() {
		this.number++;
		
	}

	@Override
	public boolean equals(Occurence occ) {
		if (name.equals(occ.name))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Number of :"+name+" = "+number;
	}
}

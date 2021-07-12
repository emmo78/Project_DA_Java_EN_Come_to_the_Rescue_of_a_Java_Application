package com.hemebiotech.model;

public class Symptom extends Occurence {

	public Symptom(String name) {
		this.name = name.toLowerCase();
		this.number = 1;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
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

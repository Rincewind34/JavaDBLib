package de.securebit.javadb.sql;

public class Limit {
	
	private int numberOne;
	private int numberTwo;
	
	public Limit(int numberOne) {
		this(numberOne, -1);
	}
	
	public Limit(int numberOne, int numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}
	
	public int getNumberOne() {
		return this.numberOne;
	}
	
	public int getNumberTwo() {
		return this.numberTwo;
	}
	
	public String asString() {
		return "LIMIT " + numberOne + (this.numberTwo <= -1 ? "": "," + this.numberTwo);
	}
	
}

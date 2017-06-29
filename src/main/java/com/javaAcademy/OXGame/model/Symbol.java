package com.javaAcademy.OXGame.model;

public enum Symbol {
	X("X"),
	O("O"),
	EMPTY(" ");
	
	private String symbol;
	
	private Symbol(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}
	
}

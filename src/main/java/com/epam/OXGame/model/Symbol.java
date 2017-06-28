package com.epam.OXGame.model;

public enum Symbol {
	X("X"),
	O("O");
	
	private String symbol;
	
	private Symbol(String symbol) {
		this.symbol = symbol;
	}

	public String getValue() {
		return symbol;
	}
	
	
}

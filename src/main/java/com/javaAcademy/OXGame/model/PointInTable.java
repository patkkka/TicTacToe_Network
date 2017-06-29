package com.javaAcademy.OXGame.model;

public class PointInTable {

	private int xCoord;
	private int yCoord;
	private Symbol symbol;
	
	public PointInTable(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
		symbol = Symbol.EMPTY;
	}

	public String getSymbol() {
		return symbol.toString();
	}

}

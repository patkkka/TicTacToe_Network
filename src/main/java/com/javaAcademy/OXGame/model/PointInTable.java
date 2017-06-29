package com.javaAcademy.OXGame.model;

public class PointInTable {

	private int xCoord;
	private int yCoord;
	private Symbol symbol;
	private boolean isOccupied = false;
	
	public PointInTable(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
		symbol = Symbol.EMPTY;
	}

	public Symbol getSymbol() {
		return symbol;
	}
	
	public void setSymbol() {
		
	}

}

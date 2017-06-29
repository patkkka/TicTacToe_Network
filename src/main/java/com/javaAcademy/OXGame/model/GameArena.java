package com.javaAcademy.OXGame.model;

public class GameArena {

	private int xDimension;
	private int yDimension;
	private PointInTable[][] arena;
	
	private GameArena(int x, int y) {
		this.xDimension = x;
		this.yDimension = y;
		createArena();
	}
	
	private void createArena() {
		arena = new PointInTable[xDimension][yDimension];
		for(int x = 0 ; x < xDimension; x++) {
			for(int y = 0 ; y < yDimension; y++) {
				arena[x][y] = new PointInTable(x, y);
			}
		}
	}

	public static GameArena getGameArena(int x , int y) {
		return new GameArena(x,y);
	}
	
	public PointInTable[][] getArena() {
		return arena;
	}
	
	public int getXDimension() {
		return xDimension;
	}
	
	public int getYDimension() {
		return yDimension;
	}
}

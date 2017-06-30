package com.javaAcademy.OXGame.model;

public enum BattleScore {

	WIN(3),
	DRAW(1),
	DEFEAT(0);
	
	int pointsForResult;
	
	private BattleScore(int amountOfPoints) {
		pointsForResult = amountOfPoints;
	}
	
	public int getPointsForResult() {
		return pointsForResult;
	}
	
}

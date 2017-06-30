package com.javaAcademy.OXGame.model;

import java.util.HashMap;
import java.util.Map;

public class GameStatistics {
	
	private Map<Symbol, Player> players = new HashMap<>();
	
	public GameStatistics(Player xPlayer, Player oPlayer) {
		players.put(xPlayer.getSymbol(), xPlayer);
		players.put(oPlayer.getSymbol(), oPlayer);
	}
	
	public void updatePlayerStatisticAfterBattle(Symbol playerSymbol, BattleScore score) {
		players.get(playerSymbol).addPoints(score);
	}
}

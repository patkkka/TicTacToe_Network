package com.javaAcademy.OXGame.model;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.helper.UserIO;

import java.util.HashMap;
import java.util.Map;

public class GameStatistics {
	
	private Map<Symbol, Player> players = new HashMap<>();
	
	public GameStatistics(Player xPlayer, Player oPlayer) {
		players.put(xPlayer.getSymbol(), xPlayer);
		players.put(oPlayer.getSymbol(), oPlayer);
	}
	
	private void updatePlayerStatisticAfterBattle(Symbol playerSymbol, BattleScore score) {
		players.get(playerSymbol).addPoints(score);
	}
	
	public void updateStatistics(BattleResult result) {
		if(result.isWinner()) {
			updatePlayerStatisticAfterBattle(result.getWinner(), BattleScore.WIN);
			updatePlayerStatisticAfterBattle(result.getLoser(), BattleScore.DEFEAT);
		} else {
			updatePlayerStatisticAfterBattle(Symbol.O, BattleScore.DRAW);
			updatePlayerStatisticAfterBattle(Symbol.X, BattleScore.DRAW);
		}
	}

	public void showStatistics(PlayerSettings playerSettings) {
		UserIO io = playerSettings.getUserIo();
		MessageResolver msg = playerSettings.getMsgResolver();
		io.showUserMessage(msg.getMsgByKey("empty.battleResult.showStatistic.head"));
		io.showUserMessage(msg.getMsgByKey("empty.battleResult.showStatistic.playerO") + players.get(Symbol.O).getAmountOfPoints());
		io.showUserMessage(msg.getMsgByKey("empty.battleResult.showStatistic.playerX") + players.get(Symbol.X).getAmountOfPoints());
	}

	public void summarizeGame(PlayerSettings playerSettings) {
		UserIO io = playerSettings.getUserIo();
		MessageResolver msg = playerSettings.getMsgResolver();
		io.showUserMessage(msg.getMsgByKey("empty.matchResult.head"));
		int pointsPlayerX = players.get(Symbol.X).getAmountOfPoints();
		int pointsPlayerO = players.get(Symbol.O).getAmountOfPoints();
		if(pointsPlayerO > pointsPlayerX) {
			io.showUserMessage(msg.getMsgByKey("empty.gameResult.playerOwin"));
		} else if(pointsPlayerX > pointsPlayerO) {
			io.showUserMessage(msg.getMsgByKey("empty.gameResult.playerXWin"));
		} else {
			io.showUserMessage(msg.getMsgByKey("empty.gameResult.draw"));
		}
	}

	public static GameStatistics getGameStatistics(PlayerSettings playerSettings) {
		UserIO io = playerSettings.getUserIo();
		MessageResolver msg = playerSettings.getMsgResolver();
		String oNickname = io.userMessageWithInput(msg.getMsgByKey("string.playerONickname"));
		String xNickname = io.userMessageWithInput(msg.getMsgByKey("string.playerXNickname"));

		Player xPlayer = new Player(xNickname, Symbol.X);
		Player oPlayer = new Player(oNickname, Symbol.O);
		return new GameStatistics(xPlayer, oPlayer);
	}
}

package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.model.BattleResult;
import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;
import com.javaAcademy.OXGame.model.PlayerSettings;

public class Game {
	
	private Game(GameSettings settings, GameStatistics statistics, PlayerSettings playerSettings) {
		int cnt = 0;
		do {
			Battle battle = new Battle(settings, playerSettings);
			BattleResult result = battle.doBattle();
			statistics.updateStatistics(result);
			statistics.showStatistics(playerSettings);
			cnt++;
		} while (cnt < settings.getAmountOfBattles());
		statistics.summarizeGame(playerSettings);
	}
	
	public static Game startGame(GameSettings settings, GameStatistics statistics, PlayerSettings playerSettings) {
		return new Game(settings, statistics, playerSettings);
	}
}

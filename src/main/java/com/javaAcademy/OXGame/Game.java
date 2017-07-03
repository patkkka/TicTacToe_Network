package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.model.BattleResult;
import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;

public class Game {
	
	private Game(GameSettings settings, GameStatistics statistics) {
		int cnt = 0;
		do {
			Battle battle = new Battle(settings);
			BattleResult result = battle.doBattle();
			statistics.updateStatistics(result);
			statistics.showStatistics();
			cnt++;
		} while (cnt < settings.getAmountOfBattles());
		statistics.summarizeGame();
	}
	
	public static Game startGame(GameSettings settings, GameStatistics statistics) {
		return new Game(settings, statistics);
	}
}

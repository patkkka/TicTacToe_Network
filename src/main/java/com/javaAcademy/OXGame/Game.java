package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;

public class Game {
	
	public Game(GameSettings settings, GameStatistics statistics) {
		int cnt = 0;
		do {
			Battle battle = new Battle();
			battle.startGame(settings.getYArenaDimension(), settings.getXArenaDimension(), settings.getWinningCondition());
			cnt++;
		} while (cnt < settings.getAmountOfBattles());
	}
}

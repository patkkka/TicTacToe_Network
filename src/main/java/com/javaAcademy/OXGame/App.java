package com.javaAcademy.OXGame;

import java.util.Locale;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.helper.UserIO;
import com.javaAcademy.OXGame.model.*;


public class App {

	public static void main(String[] args) {
		UserIO io = new UserIO(System.out,System.in);
		final int lang = Integer.parseInt(io.userMessageWithInput(
				"Please choose the language/Wybierz język: 1 - English, 2 - Polish"));
		MessageResolver msg = MessageResolver.createMessageResolver(lang);
		PlayerSettings playerSettings = new PlayerSettings(io, msg);

		GameSettings settings = GameSettings.getGameSettings(playerSettings);
		GameStatistics statistics = GameStatistics.getGameStatistics(playerSettings);

		Game.startGame(settings, statistics, playerSettings);
	}
}
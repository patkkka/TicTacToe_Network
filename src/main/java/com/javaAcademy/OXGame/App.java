package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.io.IO;
import com.javaAcademy.OXGame.io.UserIO;
import com.javaAcademy.OXGame.model.*;

import java.io.IOException;


public class App {

	public static void main(String[] args) {
		try {
			IO io = new UserIO(System.out,System.in);
			final int lang = Integer.parseInt(io.writeAndRead(
				"Please choose the language/Wybierz język: 1 - English, 2 - Polish"));
			MessageResolver msg = MessageResolver.createMessageResolver(lang);
			PlayerSettings playerSettings = new PlayerSettings(io, msg);

					GameSettings settings = GameSettings.getGameSettings(playerSettings);
			GameStatistics statistics = GameStatistics.getGameStatistics(playerSettings);
			Game.startGame(settings, statistics, playerSettings);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
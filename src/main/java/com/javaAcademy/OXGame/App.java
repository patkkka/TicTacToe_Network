package com.javaAcademy.OXGame;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;
import com.javaAcademy.OXGame.model.Player;
import com.javaAcademy.OXGame.model.Symbol;


public class App {

	public static void main(String[] args) {
		App app = new App();
		UserIO io = new UserIO(System.out,System.in);

		final int lang = Integer.parseInt(io.userMessageWithInput(
				"Please choose the language/Wybierz język: 1 - English, 2 - Polish"));
		app.createMessageResolver(lang);
		GameSettings settings = app.getGameSettings(io);
		GameStatistics statistics = app.getGameStatistics(io);

		Game.startGame(settings, statistics);
	}

	private void createMessageResolver(int langNumber) {
		switch (langNumber) {
			case 1:
				MessageResolver.createMessageResolver(new Locale("en", "EN"));
				break;
			case 2:
				MessageResolver.createMessageResolver(new Locale("pl", "PL"));
				break;
			default:
				MessageResolver.createMessageResolver(new Locale("en", "EN"));
		}
	}

	private GameStatistics getGameStatistics(UserIO io) {
		MessageResolver msgResolver = MessageResolver.msgResolverInstance();
		String oNickname = io.userMessageWithInput(msgResolver.getMsgByKey("string.playerONickname"));
		String xNickname = io.userMessageWithInput(msgResolver.getMsgByKey("string.playerXNickname"));

		Player xPlayer = new Player(xNickname, Symbol.X);
		Player oPlayer = new Player(oNickname, Symbol.O);
		return new GameStatistics(xPlayer, oPlayer);
	}

	private GameSettings getGameSettings(UserIO io) {
		MessageResolver msgResolver = MessageResolver.msgResolverInstance();
		//TODO choosing languange
		io.showUserMessage(msgResolver.getMsgByKey("empty.chosenLanguage"));

		final int xDim = Integer.parseInt(io.userMessageWithInput(msgResolver.getMsgByKey("int.xDimension")));
		final int yDim = Integer.parseInt(io.userMessageWithInput(msgResolver.getMsgByKey("int.yDimension")));
		//TODO board dimension validation

		final int charSeriesDim = Integer.parseInt(io.userMessageWithInput(msgResolver.getMsgByKey("int.winningCondition")));
		//TODO char series validation

		System.out.println("Choose who start: press 1 if O, press 2 if X:");
		//TODO char validation
		final int whoStarts = Integer.parseInt(s.nextLine());
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, "en", 3);
	}
}
package com.javaAcademy.OXGame.model;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.io.IO;
import com.javaAcademy.OXGame.io.UserIO;

import java.io.IOException;

public class GameSettings {
	
	private int whoStarts;
	private int winningCondition;
	private int xArenaDimension;
	private int yArenaDimension;
	private String language;
	private int amountOfBattles;
	
	public GameSettings(int whoStarts, int winningCondition, int xArenaDimension, 
			int yArenaDimension, String language, int amountOfBattles) {
		super();
		this.whoStarts = whoStarts;
		this.winningCondition = winningCondition;
		this.xArenaDimension = xArenaDimension;
		this.yArenaDimension = yArenaDimension;
		this.language = language;
		this.amountOfBattles = amountOfBattles;
	}

	public Symbol getWhoStarts() {
		if(whoStarts == 1) {
			return Symbol.O;
		}
		return Symbol.X;
	}

	public int getWinningCondition() {
		return winningCondition;
	}

	public int getXArenaDimension() {
		return xArenaDimension;
	}

	public int getYArenaDimension() {
		return yArenaDimension;
	}

	public String getLanguage() {
		return language;
	}
	
	public int getAmountOfBattles() {
		return amountOfBattles;
	}

	public static GameSettings getGameSettings(PlayerSettings playerSettings) throws IOException{
		IO io = playerSettings.getIO();
		MessageResolver msg = playerSettings.getMsgResolver();
		//TODO choosing languange
		io.write(msg.getMsgByKey("empty.chosenLanguage"));

		final int xDim = Integer.parseInt(io.writeAndRead(msg.getMsgByKey("int.xDimension")));
		final int yDim = Integer.parseInt(io.writeAndRead(msg.getMsgByKey("int.yDimension")));
		//TODO board dimension validation

		final int charSeriesDim = Integer.parseInt(io.writeAndRead(msg.getMsgByKey("int.winningCondition")));
		//TODO char series validation

		final int whoStarts = Integer.parseInt(io.writeAndRead(msg.getMsgByKey("int.whoStarts")));
		//TODO char validation
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, "en", 3);
	}
}

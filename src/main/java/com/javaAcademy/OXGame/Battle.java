package com.javaAcademy.OXGame;

import java.util.Scanner;

import com.javaAcademy.OXGame.businessLogic.CheckerAlgorithm;
import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.helper.UserIO;
import com.javaAcademy.OXGame.model.*;
import com.javaAcademy.OXGame.view.TablePrinter;

public class Battle {

	private GameSettings settings;
	private PlayerSettings playerSettings;

	public Battle(GameSettings settings, PlayerSettings playerSettings) {
		this.settings = settings;
		this.playerSettings = playerSettings;
	}

	public BattleResult doBattle() {
		MessageResolver msg = playerSettings.getMsgResolver();
		UserIO io = playerSettings.getUserIo();
		GameArena gameArena = GameArena.getGameArena(settings.getXArenaDimension(), settings.getYArenaDimension());
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, settings.getWinningCondition());
		int cnt = 0;
		TablePrinter.printArena(gameArena); 
		Symbol symbol = null;
		do{
			if(cnt%2 == 0) {
				symbol = settings.getWhoStarts();
			} else {
				symbol = symbol.getOppositeSymbol(settings.getWhoStarts());
			}
			
			if(checkNextMove(symbol, gameArena, checker)) {
				io.showUserMessage(msg.getMsgByKey("empty.battleWinner")+ symbol.toString());
				return new BattleResult(symbol, symbol.getOppositeSymbol(symbol), true);
			}
	    	cnt++;
	    	TablePrinter.printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols());
		io.showUserMessage(msg.getMsgByKey("empty.battleNoWinner"));
		return new BattleResult(Symbol.O, Symbol.X, false);
	}
	
	private boolean checkNextMove(Symbol symbol, GameArena gameArena, CheckerAlgorithm checker) {
		gameArena.setSymbol(symbol, isEmpty(gameArena, symbol, this.playerSettings));
		return checker.win(gameArena, symbol);
	}

	private static Point isEmpty(GameArena arena, Symbol symbol, PlayerSettings playerSettings) {
		UserIO io = playerSettings.getUserIo();
		MessageResolver msg = playerSettings.getMsgResolver();
		io.showUserMessage(msg.getMsgByKey("empty.whoTurn.first") + symbol + msg.getMsgByKey("empty.whoTurn.second"));

    	final int yDim = Integer.parseInt(io.userMessageWithInput(msg.getMsgByKey("int.algo.xCoord")));
    	final int xDim = Integer.parseInt(io.userMessageWithInput(msg.getMsgByKey("int.algo.yCoord")));
    	
    	io.showUserMessage(msg.getMsgByKey("empty.chosenCoords") + xDim+"|"+yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim,yDim);
		}
		io.showUserMessage(msg.getMsgByKey("empty.pointOccupied"));
		return isEmpty(arena, symbol, playerSettings);
	}
	
}

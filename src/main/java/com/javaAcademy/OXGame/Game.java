package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.view.TablePrinter;

public class Game {
	
	public void startGame(int x, int y) {
		GameArena gameArena = GameArena.getGameArena(x,y);
		TablePrinter.printArena(gameArena); 
		
	}
}

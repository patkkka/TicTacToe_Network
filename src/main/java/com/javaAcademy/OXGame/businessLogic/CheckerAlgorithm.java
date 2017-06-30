package com.javaAcademy.OXGame.businessLogic;

import com.javaAcademy.OXGame.model.Direction;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Point;
import com.javaAcademy.OXGame.model.Symbol;
import com.javaAcademy.OXGame.model.directions.AscensionalDirection;
import com.javaAcademy.OXGame.model.directions.DescendingDirection;
import com.javaAcademy.OXGame.model.directions.HoryzontalDirection;
import com.javaAcademy.OXGame.model.directions.VerticalDirection;

public class CheckerAlgorithm {
	
	private GameArena arena;
	private boolean isWinner = false;
	private int winCondition;
	
	public CheckerAlgorithm(GameArena gameArena, int winCondition) {
		this.arena = gameArena;
		this.winCondition = winCondition;
	}

	public boolean win(GameArena arena, Symbol checkedSymbol) {
		check(checkedSymbol);
		return isWinner;
	}
	
	private void check(Symbol userChar) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkFromPoint(x, y, new VerticalDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new HoryzontalDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new DescendingDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, new AscensionalDirection(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
			}
		}
	}
	
	private void checkFromPoint(int x, int y, Direction direction, Symbol symbol) {
		int cnt = 0;
		for(int i = 0; i < winCondition ; i++) {
			if(symbol.equals(arena.getArena()[x][y])) {
				cnt++;
			}
			Point point = direction.getNextPoint(x, y);
			x = point.getX();
			y = point.getY();
		}
		if(cnt == winCondition) {
			isWinner = true;
			System.out.println("WYGRAŁ GRACZ: " + symbol.toString());
		}
	}
}


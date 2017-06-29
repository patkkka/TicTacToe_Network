package com.javaAcademy.OXGame.businessLogic;

import com.javaAcademy.OXGame.model.Direction;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Symbol;

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
					checkFromPoint(x, y, Direction.vertical(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, Direction.horyzontal(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, Direction.descending(), userChar);
				} catch(ArrayIndexOutOfBoundsException e) {}
				try {
					checkFromPoint(x, y, Direction.ascensional(), userChar);
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
			if(direction.isVertical()) {
				y++;
			}
			if(direction.isHoryzontal()) {
				x++;
			}
			if(direction.isDescending()) {
				x++;
				y++;
			}
			if(direction.isAscensional()) {
				x--;
				y++;
			}
		}
		if(cnt == winCondition) {
			isWinner = true;
			System.out.println("WYGRAŁ GRACZ: " + symbol.toString());
		}
	}
}


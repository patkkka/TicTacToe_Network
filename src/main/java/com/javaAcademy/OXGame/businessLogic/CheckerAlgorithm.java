package com.javaAcademy.OXGame.businessLogic;

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
		checkAscensionalDiagonal(checkedSymbol);
		checkDescensionalDiagonal(checkedSymbol);
		checkHorizontal(checkedSymbol);
		checkVertical(checkedSymbol);
		return isWinner;
	}
	
	private void checkHorizontal(Symbol userChar) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkHoryzontalOrDiagonalFromPoint(x, y, true, userChar);
				} catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	
	private void checkVertical(Symbol userChar) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkHoryzontalOrDiagonalFromPoint(x, y, false, userChar);
				} catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	
	private void checkHoryzontalOrDiagonalFromPoint(int x, int y, boolean isHoryzontal, Symbol symbol) {
		int cnt = 0;
		for(int i = 0; i < winCondition ; i++) {
			if(symbol.equals(arena.getArena()[x][y])) {
				cnt++;
			}
			if(isHoryzontal) {
				x++;
			} else {
				y++;
			}
		}
		if(cnt == winCondition) {
			isWinner = true;
			System.out.println("WYGRAŁ GRACZ: " + symbol.toString());
		}
	}
	
	
	private void checkAscensionalDiagonal(Symbol checkedSymbol) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkDiagonalFromPoint(x, y, false, checkedSymbol);
				} catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	private void checkDescensionalDiagonal(Symbol checkedSymbol) {
		for(int x = 1; x < arena.getXDimension(); x++) {
			for(int y = 1; y < arena.getYDimension(); y++) {
				try {
					checkDiagonalFromPoint(x, y, true, checkedSymbol);
				} catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
	
	private void checkDiagonalFromPoint(int x, int y, boolean isDescending, Symbol symbol) {
		int diagonalCnt = 0;
		for(int i = 0; i < winCondition ; i++) {
			if(symbol.equals(arena.getArena()[x][y])) {
				diagonalCnt++;
			}
			if(isDescending) {
				x++;
			} else {
				x--;
			}
			y++;
		}
		if(diagonalCnt == winCondition) {
			isWinner = true;
			System.out.println("WYGRAŁ GRACZ: " + symbol.toString());
		}
	}
}


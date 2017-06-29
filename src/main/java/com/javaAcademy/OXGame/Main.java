package com.javaAcademy.OXGame;

import java.util.Scanner;

import com.javaAcademy.OXGame.model.Symbol;

public class Main {

	public static void main(String[] args) {
		
		Symbol[][] arena = new Symbol[4][4];
		for(int x=1; x<4;x++){
			for(int y=1; y<4;y++){
				arena[x][y] = Symbol.EMPTY;
			}
		}
		show(arena);
		int cnt = 0;
		do{
			if(cnt%2 == 0) {
				setChar(arena, Symbol.O, isEmpty(arena));
			} else {
				setChar(arena, Symbol.X, isEmpty(arena));
			}
			
	    	cnt++;
	    	show(arena);
		} while(cnt < 10);
	}
	
	private static Point isEmpty(Symbol[][] arena) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Choose y: ");
    	final int yDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose x: ");
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	
    	System.out.println("You chose: " + xDim+"|"+yDim);
		
		if((arena[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim,yDim);
		}
		System.out.println("Point is occupied! Please choose new");
		return isEmpty(arena);
	}
	
	private static void setChar(Symbol[][] arena, Symbol symbol, Point point) {
    	arena[point.getX()][point.getY()] = symbol;
	}

	private static void show(Symbol[][] arena) {
		for(int x=1; x<4;x++){
			System.out.println();
			for(int y=1; y<4;y++){
				System.out.print( " |" + arena[x][y]);
			}
		}
	}

}

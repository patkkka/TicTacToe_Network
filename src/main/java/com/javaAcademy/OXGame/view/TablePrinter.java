package com.javaAcademy.OXGame.view;

import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.PointInTable;

public class TablePrinter {

	public static void printArena(GameArena arena) {
		PointInTable[][] playArena = arena.getArena();
		for(int x = 0; x < arena.getXDimension(); x++) {
			System.out.println();
			for(int y = 0; y < arena.getYDimension(); y++) {
				System.out.print("  |" +  printPoint(playArena[x][y]) );
			}
		}
	}
	
	public static String printPoint(PointInTable point) {
		return point.getSymbol();
	}	
}

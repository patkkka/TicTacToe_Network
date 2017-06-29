package com.javaAcademy.OXGame.AlgorithmTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.javaAcademy.OXGame.businessLogic.CheckerAlgorithm;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Point;
import com.javaAcademy.OXGame.model.Symbol;

public class VerticalTest {
	/* Vertical Tests*/
	@Test
	public void testVerticalThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(2,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testVerticalThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,1));
		gameArena.setSymbol(Symbol.O, new Point(2,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
	
	@Test
	public void testVerticalThreeSymbolOInARowOn3x5Arena() {
		GameArena gameArena = GameArena.getGameArena(3, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(2,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testVerticalThreeSymbolONotInARowOn3x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(3, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,1));
		gameArena.setSymbol(Symbol.O, new Point(2,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
}

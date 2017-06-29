package com.javaAcademy.OXGame.AlgorithmTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.javaAcademy.OXGame.businessLogic.CheckerAlgorithm;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Point;
import com.javaAcademy.OXGame.model.Symbol;

public class AscensionalTest {
	
	/* Ascensional Tests */
	@Test
	public void testAscensionalThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testAscensionalThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(5,1));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
	
	@Test
	public void testAscensionalThreeSymbolOInARowOn5x4Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 4);
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testAscensionalThreeSymbolONotInARowOn5x4BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 4);
		gameArena.setSymbol(Symbol.O, new Point(5,1));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(2,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
}

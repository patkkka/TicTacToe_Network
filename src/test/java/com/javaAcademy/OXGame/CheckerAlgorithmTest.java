package com.javaAcademy.OXGame;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.javaAcademy.OXGame.businessLogic.CheckerAlgorithm;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Point;
import com.javaAcademy.OXGame.model.Symbol;

public class CheckerAlgorithmTest {
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
	
	/* Horyzontal Tests*/
	@Test
	public void testHoryzontalThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testHoryzontalThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(1,2));
		gameArena.setSymbol(Symbol.O, new Point(3,2));
		gameArena.setSymbol(Symbol.O, new Point(4,2));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}
	
	
	/* Descending Tests */
	@Test
	public void testDescendingThreeSymbolOInARowOn5x5Arena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(2,2));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(4,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), true);
	}
	
	@Test
	public void testDescendingThreeSymbolONotInARowOn5x5BoardArena() {
		GameArena gameArena = GameArena.getGameArena(5, 5);
		gameArena.setSymbol(Symbol.O, new Point(1,1));
		gameArena.setSymbol(Symbol.O, new Point(3,3));
		gameArena.setSymbol(Symbol.O, new Point(4,4));
		
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, 3);
		assertEquals(checker.win(gameArena, Symbol.O), false);
	}

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

}

package com.javaAcademy.OXGame;

import com.javaAcademy.OXGame.model.Symbol;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SymbolTest {

	@Test
	public void testSymbolX() {
		Symbol x = Symbol.X;
		assertEquals(1+1,2);
		assertEquals("X", x.toString());
	}
	
	@Test
	public void testSymbolO() {
		Symbol o = Symbol.O;
		assertEquals("O", o.toString());
	}
	
	@Test
	public void testSymbolOIsNotEqualsSymbolX() {
		assertFalse(Symbol.O.toString().equals(Symbol.X.toString()));
	}
}

package com.epam.OXGame;

import org.junit.Test;
import static org.junit.Assert.*;

import com.epam.OXGame.model.Symbol;

public class SymbolTest {

	@Test
	public void testSymbolX() {
		Symbol x = Symbol.X;
		assertEquals("X", x.getValue());
	}
	
	@Test
	public void testSymbolO() {
		Symbol o = Symbol.O;
		assertEquals("O", o.getValue());
	}
	
	@Test
	public void testSymbolOIsNotEqualsSymbolX() {
		assertNotSame(Symbol.O.getValue(), Symbol.X.getValue());
	}
}

package com.javaAcademy.OXGame;

import org.junit.Test;

import com.javaAcademy.OXGame.model.Symbol;

import static org.junit.Assert.*;

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

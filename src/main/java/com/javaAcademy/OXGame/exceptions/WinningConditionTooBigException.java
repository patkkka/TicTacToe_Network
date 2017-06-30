package com.javaAcademy.OXGame.exceptions;

public class WinningConditionBiggerThanArenaDimensionException extends RuntimeException{

	private static final long serialVersionUID = 477324754522419687L;

	public WinningConditionBiggerThanArenaDimensionException(String message) {
		super(message);
	}
}

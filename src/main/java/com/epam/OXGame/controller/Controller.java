package com.epam.OXGame.controller;

import java.util.Scanner;

public class Controller {
	private Scanner scanner;
	
	public Controller() {
		scanner = new Scanner(System.in);
	}

	public String getReturnInt() {
		return scanner.nextLine();
	}
}

package com.javaAcademy.OXGame;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.javaAcademy.OXGame.helper.MessageResolver;


public class App 
{
    public static void main( String[] args )
    {/*
        String language = new String("en");
        String country = new String("EN");
        
        String plLanguage = new String("pl");
        String plCountry = new String("PL");
        
        Locale defaultLocale = new Locale(language, country);
        Locale plLocale = new Locale(plLanguage, plCountry);
        
		MessageResolver msgResolver = MessageResolver.msgResolverInstance(defaultLocale);
        System.out.println(msgResolver.getMsgByKey("hello"));
        
*/
    	
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish.");
    	Scanner s = new Scanner(System.in);
    	//final int lang = Integer.parseInt(s.nextLine());
    	//TODO choosing languange
    	System.out.println("You chose English");
    	
    	System.out.println("Choose board X dimension: ");
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose board Y dimension: ");
    	final int yDim = Integer.parseInt(s.nextLine());
    	//TODO board dimension validation
    	
    	System.out.println("Choose how many charakters to win: ");
    	//TODO char series validation
    	//final int charSeriesDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose who start: O or X:");
    	//TODO char validation
    	//String symbol = s.nextLine();
    	
    	//TODO create a game
    	Game game = new Game();
    	game.startGame(yDim, xDim);
    	//TODO create symbols and players
    	//TODO create a board
    	//TODO create view 
    	//TODO create game statistics 
    	
    	//TODO create one battle
    	//TODO create winner finder algo
    	//TODO create battle result
    	
    	
    	
    }
}

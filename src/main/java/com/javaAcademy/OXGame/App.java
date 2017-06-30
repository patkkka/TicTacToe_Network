package com.javaAcademy.OXGame;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.javaAcademy.OXGame.helper.MessageResolver;
import com.javaAcademy.OXGame.model.GameSettings;
import com.javaAcademy.OXGame.model.GameStatistics;
import com.javaAcademy.OXGame.model.Player;
import com.javaAcademy.OXGame.model.Symbol;


public class App {
	
	Scanner s = new Scanner(System.in);
	
    public static void main( String[] args ) {
    	/*
        String language = new String("en");
        String country = new String("EN");
        
        String plLanguage = new String("pl");
        String plCountry = new String("PL");
        
        Locale defaultLocale = new Locale(language, country);
        Locale plLocale = new Locale(plLanguage, plCountry);
        
		MessageResolver msgResolver = MessageResolver.msgResolverInstance(defaultLocale);
        System.out.println(msgResolver.getMsgByKey("hello"));
        
*/	
    	App app = new App();
    	GameSettings settings = app.getGameSettings();
    	GameStatistics statistics = app.getGameStatistics();
    	
    	Game game = new Game(settings, statistics);
    }
    
    private GameStatistics getGameStatistics() {
    	
    	System.out.println("Please enter O player nickname: ");
    	String oNickname = s.nextLine();
    	
    	System.out.println("Please enter X player nickname: ");
    	String xNickname = s.nextLine();

    	Player xPlayer = new Player(xNickname, Symbol.X);
    	Player oPlayer = new Player(oNickname, Symbol.O);
    	return new GameStatistics(xPlayer, oPlayer);
    }
    
    private GameSettings getGameSettings() {
    	//System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish.");
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
    	final int charSeriesDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("Choose who start: press 1 if O, press 2 if X:");
    	//TODO char validation
    	final int whoStarts = Integer.parseInt(s.nextLine());
		return new GameSettings(whoStarts, charSeriesDim, xDim, yDim, "en", 3);
    }
}

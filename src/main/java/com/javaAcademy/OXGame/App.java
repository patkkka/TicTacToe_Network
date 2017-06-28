package com.javaAcademy.OXGame;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
       /* String language = new String("en");
        String country = new String("EN");
        
        String plLanguage = new String("pl");
        String plCountry = new String("PL");
        
        Locale defaultLocale = new Locale(language, country);
        Locale plLocale = new Locale(plLanguage, plCountry);
        
        ResourceBundle messages = ResourceBundle.getBundle("Messages", defaultLocale);
        System.out.println(messages.getString("hello"));
        
        ResourceBundle messagesPL = ResourceBundle.getBundle("Messages", plLocale);
        System.out.println(messagesPL.getString("hello"));
*/
    	
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish.");
    	Scanner s = new Scanner(System.in);
    	final int lang = Integer.parseInt(s.nextLine());
    	
    }
}

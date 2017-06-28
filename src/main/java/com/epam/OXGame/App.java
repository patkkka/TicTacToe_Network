package com.epam.OXGame;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String language = new String("en");
        String country = new String("EN");
        
        String plLanguage = new String("pl");
        String plCountry = new String("PL");
        
        Locale defaultLocale = new Locale(language, country);
        Locale plLocale = new Locale(plLanguage, plCountry);
        
        ResourceBundle messages = ResourceBundle.getBundle("Messages", defaultLocale);
        System.out.println(messages.getString("hello"));
        
        ResourceBundle messagesPL = ResourceBundle.getBundle("Messages", plLocale);
        System.out.println(messagesPL.getString("hello"));

    }
}

package com.epam.OXGame;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.epam.OXGame.helper.MessageResolver;

public class MessagesTest {
	
	private String language = new String("en");
    private String country = new String("EN");
    
	@Test
	public void testInternationalization() {
        
        Locale defaultLocale = new Locale(language, country);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", defaultLocale);
        
        assertEquals("Hello my friend!.", messages.getString("hello"));
	}
	
	@Test
	public void testInternationalizationFromMessageResolver() {
		Locale defaultLocale = new Locale(language, country);
		
		MessageResolver msgResolver = new MessageResolver(defaultLocale);
		String key = "hello";
		
		assertEquals("Hello my friend!.", msgResolver.getMsgByKey(key));
		
	}
	
}

package com.javaAcademy.OXGame;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;


import com.javaAcademy.OXGame.helper.MessageResolver;

@Test
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
		
		MessageResolver msgResolver = MessageResolver.msgResolverInstance(defaultLocale);
		String key = "hello";
		
		assertEquals("Hello my friend!.", msgResolver.getMsgByKey(key));
		
	}
	
}

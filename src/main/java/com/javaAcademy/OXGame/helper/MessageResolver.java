package com.javaAcademy.OXGame.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResolver {
	
	private ResourceBundle messages;
	
	public MessageResolver(Locale locale) {
		this.messages = ResourceBundle.getBundle("Messages", locale);
	}

	public String getMsgByKey(String key) {
		return messages.getString(key);
	}

}

package com.javaAcademy.OXGame.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResolver {
	private Locale locale;

	public MessageResolver(MessageResolver msg) {
		this.locale = msg.getLocale();
	}

	public MessageResolver(Locale locale) {
		this.locale = locale;
	}

	public String getMsgByKey(String key) {
		//TODO data checker by key beginning
		return ResourceBundle.getBundle("Messages", locale).getString(key);
	}

	private Locale getLocale() {
		return locale;
	}

	public static MessageResolver createMessageResolver(int langNumber) {
		switch (langNumber) {
			case 1:
				return new MessageResolver(new Locale("en", "EN"));
			case 2:
				return new MessageResolver(new Locale("pl", "PL"));
			default:
				return new MessageResolver(new Locale("en", "EN"));
		}
	}
}

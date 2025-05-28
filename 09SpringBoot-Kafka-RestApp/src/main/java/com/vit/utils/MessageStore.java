//MessageStore.java
package com.vit.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String> messages = new ArrayList<>();
	
	public void addMessage(String msg) {
		messages.add(msg);
	}
	
	public List<String> getMessages() {
		return messages;
	}
}

//SubscriberApp.java
package com.vit.runner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriberApp{
	
	@JmsListener(destination = "topic1")
	public void readMessage(String msg){
		System.out.println("SubscriberApp.readMessage() - Received Message :: "+msg);
	}

}

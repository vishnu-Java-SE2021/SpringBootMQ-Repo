//ReceiverApp.java
package com.vit.runner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverApp{
	
	@JmsListener(destination = "testQueue1")
	public void readMessage(String msg){
		System.out.println("Received Message :: "+msg);
	}

}

//ReceiverApp.java
package com.vit.runner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.vit.model.Product;

@Component
public class ReceiverApp{
	
	@JmsListener(destination = "Obj_MQ1")
	public void readMessage(Product product){
		System.out.println("Received Message :: "+product);
	}

}

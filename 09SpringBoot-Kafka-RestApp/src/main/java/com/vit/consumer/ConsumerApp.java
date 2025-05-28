//ConsumerApp.java
package com.vit.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.vit.utils.MessageStore;

@Component("consumer")
public class ConsumerApp {
	
	@Autowired
	private MessageStore store;

	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1")
	public void readMessage(String msg) {
		store.addMessage(msg);
	}
	
}

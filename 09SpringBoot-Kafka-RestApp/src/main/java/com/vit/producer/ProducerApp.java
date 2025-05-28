//ProducerApp.java
package com.vit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component("producer")
public class ProducerApp {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Value("${app.topic.name}")
	private String topicname;
	
	public String sendMessage(String msg) {
		template.send(topicname, msg);
		return "Message :: "+msg;
	}
}

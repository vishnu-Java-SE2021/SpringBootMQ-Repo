package com.vit.runner;

//PublisherApp.java
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;

@Component
public class PublisherApp{

	@Autowired
	JmsTemplate template;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() throws JMSException {
		template.send("topic1", ses -> ses.createTextMessage("Message sent at :: "+ new Date()));
		System.out.println("PublisherApp.sendMessage() "+ new Date());
	}

}

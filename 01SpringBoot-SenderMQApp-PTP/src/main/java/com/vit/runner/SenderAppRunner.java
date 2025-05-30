package com.vit.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;

@Component
public class SenderAppRunner {

	@Autowired
	JmsTemplate template;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() throws JMSException {
		template.send("testQueue1", ses -> ses.createTextMessage("Message sent at :: "+ new Date()));
		System.out.println("SenderAppRunner.run() "+ new Date());
	}

}

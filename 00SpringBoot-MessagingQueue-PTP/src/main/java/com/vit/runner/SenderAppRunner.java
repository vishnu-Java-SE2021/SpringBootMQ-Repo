package com.vit.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SenderAppRunner implements CommandLineRunner {

	@Autowired
	JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		template.send("queue1", ses -> ses.createTextMessage("Message sent at :: "+ new Date()));
		System.out.println("SenderAppRunner.run() "+ new Date());
	}

}

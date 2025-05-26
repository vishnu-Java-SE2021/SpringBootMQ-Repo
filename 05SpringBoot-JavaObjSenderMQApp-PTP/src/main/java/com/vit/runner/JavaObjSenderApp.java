package com.vit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vit.model.Product;

import jakarta.jms.JMSException;

@Component
public class JavaObjSenderApp {

	@Autowired
	JmsTemplate template;
	
	@Scheduled(cron = "*/15 * * * * *")
	public void sendMessageAsObj() throws JMSException {
		Product product = new Product(1,"Tab",30000);
		template.convertAndSend("Obj_MQ1", product);
		System.out.println("JavaObjSenderApp.sendMessageAsObj() - Object sent :: "+ product);
	}

}

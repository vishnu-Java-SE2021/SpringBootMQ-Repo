//KafkaRestApp.java
package com.vit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vit.producer.ProducerApp;
import com.vit.utils.MessageStore;

@RestController
public class KafkaRestApp {

	@Autowired
	private MessageStore store;
	
	@Autowired
	private ProducerApp producer;
	
	@GetMapping("/send")
	public ResponseEntity<?> sendMessage(@RequestParam("message") String msg){
		String status = producer.sendMessage(msg);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/readAllMessages")
	public ResponseEntity<?> fetchAllMessages(){
		List<String> messages = store.getMessages();
		return new ResponseEntity<List<String>>(messages, HttpStatus.OK);
	}
}

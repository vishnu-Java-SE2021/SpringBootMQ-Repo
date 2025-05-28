//kafkaProducerApp.java
package com.vit.Spring_kafka_ProducerApp;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class kafkaProducerApp {
    public static void main( String[] args ){
    	
    	Properties props = new Properties();
    	props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	KafkaProducer<String, String> producer = new KafkaProducer<>(props);
    	
    	ProducerRecord<String, String> record = null;
    	Scanner sc = new Scanner(System.in);
    	String msg = null;
    	do {
    		System.out.print("Message: ");
    		msg = sc.nextLine();
    		record = new ProducerRecord<String, String>("vit-tpc",msg);
    		
    		producer.send(record);
    		producer.flush();
    	}while(!msg.equalsIgnoreCase("stop"));
    	
    	producer.close();
    	sc.close();
    	System.out.println("kafkaProducerApp.main()");
    }
}

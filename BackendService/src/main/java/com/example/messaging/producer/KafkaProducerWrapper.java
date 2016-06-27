package com.example.messaging.producer;
 
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.broker.producer.BasicKafkaProducerWrapper;

@Component
public class KafkaProducerWrapper extends BasicKafkaProducerWrapper {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerWrapper.class);

    @PostConstruct
    public void init() {
    	Properties kafkaProps = new Properties();
		try {
			kafkaProps.load(this.getClass().getClassLoader().getResourceAsStream("kafka.properties"));
		} catch (IOException e) {
			logger.error("Could not load the kafka configuration.", e);
		}
		super.init(kafkaProps);
    }
}
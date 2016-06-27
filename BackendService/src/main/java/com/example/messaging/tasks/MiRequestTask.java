package com.example.messaging.tasks;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.messages.MiReply;
import com.example.messages.MiRequest;
import com.example.messaging.producer.KafkaProducerWrapper;
import com.example.model.MobileInternet;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MiRequestTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MiRequestTask.class);
	private String message;
	
	private ObjectMapper mapper;
	private UserService userService;
	private KafkaProducerWrapper producer;
	private String replyTopic;
	
	public MiRequestTask(String message, ObjectMapper mapper, UserService userService, KafkaProducerWrapper producer, String replyTopic) {
		super();
		this.message = message;
		this.mapper = mapper; 
		this.userService = userService;
		this.producer = producer;
		this.replyTopic = replyTopic;
	}

	@Override
	public void run() {
		logger.info("[message: {}] starts ...", message);
		try {
			final MiRequest request = mapper.readValue(message, MiRequest.class);
			final Optional<MobileInternet> miOpt = userService.getUserMi(request.getUsername());
			if(miOpt.isPresent()){
				MiReply reply = new MiReply();
				MobileInternet mi = miOpt.get();
				reply.setSessionId(request.getSessionId());
				reply.setCorrelationId(request.getCorrelationId());
				
				reply.setBalance(mi.getBalance());
				reply.setSallefny(mi.getSallefny());
				reply.setRatePlan(mi.getRatePlan());
				reply.setConsumedQouta(mi.getConsumedData());
				reply.setTotalQouta(mi.getTotalQouta());
				reply.setUsbMsisdn(mi.getUsbMsisdn());
				
				String replyMessage = mapper.writeValueAsString(reply);
				logger.info("[message: {}] done. result: {}", message, replyMessage);
				producer.send(replyTopic, replyMessage);
			} else {
				logger.info("[message: {}] done. no user found.", message);
			}
		} catch (IOException e) {
			logger.error("[message: {}] could not parse the message as MiRequest.", message, e);
		} catch (Exception e) {
			logger.error("[message: {}] an error occured while processing the message.", message, e);
		} 
		
	}
}

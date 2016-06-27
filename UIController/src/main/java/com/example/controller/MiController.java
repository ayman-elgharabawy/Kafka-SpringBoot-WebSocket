package com.example.controller;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.UserSessionsRepository;
import com.example.dto.User;
import com.example.messages.MiRequest;
import com.example.messaging.producer.KafkaProducerWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MiController {
	private static final Logger logger = LoggerFactory.getLogger(MiController.class);
	@Value("${mi.request.topic}")
	private String miRequestsTopic;
	
	@Autowired
	private UserSessionsRepository sessions;
	
	@Autowired
	private KafkaProducerWrapper messageProducer;
	
	private ObjectMapper mapper = new ObjectMapper();
    
    @MessageMapping("/mi")
    public void getMiDetails(User user, @Headers Map<String, Object> headers) {
    	logger.info("getMiDetails(user: {}): starts ...", user);
    	if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
    		logger.info("getMiDetails(user: {}): user name is empty, ignoring the request.", user);
    		return;
    	}
    	
    	String sessionId = SimpMessageHeaderAccessor.getSessionId(headers);
    	if(sessionId == null || sessionId.isEmpty()) {
    		logger.info("getMiDetails(user: {}): no websocket session found, ignoring the request.", user);
    		return;
    	}
    	
		sessions.put(sessionId, "");
		
		try {
    		String messageText = mapper.writeValueAsString(new MiRequest(UUID.randomUUID().toString(), sessionId, user.getUsername()));
    		logger.info("getMiDetails(user: {}): sending request to message broker...", user);
    		messageProducer.send(miRequestsTopic, messageText);
    		logger.info("getMiDetails(user: {}): done.", user);
		} catch(JsonProcessingException ex) {
			logger.error("getMiDetails(user: {}): failed, an error occured while parsing the request to json.", user, ex);
		}
    }
}
package com.example.messaging.tasks;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.example.UserSessionsRepository;
import com.example.dto.MiResponse;
import com.example.messages.MiReply;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MiReplyTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MiReplyTask.class);
	
	private static final String clientTopic = "/topic/mi";
	private String replyText;
	private ObjectMapper mapper;
	private UserSessionsRepository sessions;
	private SimpMessagingTemplate template;

	public MiReplyTask(String replyText, ObjectMapper mapper, UserSessionsRepository sessions,
			SimpMessagingTemplate template) {
		super();
		this.replyText = replyText;
		this.mapper = mapper;
		this.sessions = sessions;
		this.template = template;
	}

	@Override
	public void run() {
		try {
			MiReply reply = mapper.readValue(this.replyText, MiReply.class);
			String sessionId = (reply == null) ? null : reply.getSessionId();
			if (sessionId != null && sessions.containsKey(sessionId)) {
				MiResponse response = new MiResponse();
				response.setUsbMsisdn(reply.getUsbMsisdn());
				response.setBalance(reply.getBalance());
				response.setRatePlan(reply.getRatePlan());
				response.setSallefny(reply.getSallefny());
				response.setConsumedQouta(reply.getConsumedQouta());
				response.setTotalQouta(reply.getTotalQouta());
				
				logger.info("Sending reponse back to the cliend: {}", response);
				this.template.convertAndSendToUser(sessionId, clientTopic, response, createMessageHeaders(sessionId));
			} else {
				logger.info("No associted session found for id: {}", sessionId);
			}
		} catch (IOException e) {
			logger.error("Could not parse message: {}", replyText, e);
		}
	}

	private MessageHeaders createMessageHeaders(String sessionId) {
		SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
		headerAccessor.setSessionId(sessionId);
		headerAccessor.setLeaveMutable(true);
		return headerAccessor.getMessageHeaders();
	}

}

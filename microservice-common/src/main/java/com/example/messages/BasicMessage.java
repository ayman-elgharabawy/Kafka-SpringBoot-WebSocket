package com.example.messages;

public class BasicMessage {
	private String correlationId;
	private String sessionId;

	public BasicMessage(String correlationId, String sessionId) {
		super();
		this.correlationId = correlationId;
		this.sessionId = sessionId;
	}

	public BasicMessage() {
		super();
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "BasicMessage {\"correlationId\":" + correlationId + ", \"sessionId\":" + sessionId + "}";
	}
}

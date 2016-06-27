package com.example.dto;

import java.io.Serializable;

public class Advertisement implements Serializable {
	private static final long serialVersionUID = -654945268735609316L;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

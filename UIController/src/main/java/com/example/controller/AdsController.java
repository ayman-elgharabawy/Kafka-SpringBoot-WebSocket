package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Advertisement;

@RestController
@RequestMapping("/marketing")
public class AdsController {
	
	private SimpMessagingTemplate template;

	@Autowired
    public AdsController(SimpMessagingTemplate template) {
        this.template = template;
    }
	

	@RequestMapping(value = "/ads", method = RequestMethod.POST)
	public @ResponseBody String sendAdvertisment(@RequestBody Advertisement advertisment) {
		try {
			System.out.println("[sendAdvertisment] called with advertisment: " + advertisment);
			this.template.convertAndSend("/topic/ads", advertisment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Request has been sent";
	}

}

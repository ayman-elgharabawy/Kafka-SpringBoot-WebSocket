package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.messaging.producer.KafkaProducerWrapper;


@RestController
@RequestMapping("/auth")

public class UserController {
	@Value("${producetopic}")
	private String topic;
	
    @Autowired  
    KafkaProducerWrapper springBootKafkaProducer;
	
	@RequestMapping("/validData")
	public @ResponseBody String getUserData(@RequestParam("userid") String userid,@RequestParam("password") String password)
	{
		try{
	    	 springBootKafkaProducer.send(topic,userid).get();
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	        return "{\"username\": \"mostafa\", \"password\":\"123\", \"msisdn\": \"122233344\"}";
	}
	
    @RequestMapping(value="/send", method=RequestMethod.POST)
    public @ResponseBody String createBE(@RequestBody String userdata)
    {
    	String jsonInString="";
    	try{
    		System.out.println("================JSON Object=====================");
        	System.out.println(userdata);
        	
    		springBootKafkaProducer.send(topic, userdata).get();
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	
    	 
     return "Request has been sent";
    }
}

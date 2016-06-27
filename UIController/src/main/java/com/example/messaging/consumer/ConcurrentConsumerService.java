package com.example.messaging.consumer;

import java.util.HashMap;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.UserSessionsRepository;
import com.example.broker.consumer.DefaultConcurrentConsumerService;
import com.example.messaging.tasks.MiReplyTask;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConcurrentConsumerService extends DefaultConcurrentConsumerService {

	@Value("${mi.response.topic}")
    private String topic;
	
    private static final Integer CONSUMER_NUM_THREADS = 1;
    private static final Integer LISTENER_NUM_THREADS = 1;
    private static final Integer EXECUTOR_NUM_THREADS = 4;
    
    @Autowired
    private ConsumerConfigFactory consumerConfigFactory;
    
    @Autowired
    private UserSessionsRepository sessions;
    
    @Autowired
    private SimpMessagingTemplate template;
    
    private ObjectMapper mapper;
    
    @PostConstruct
    public void startConsuming() {
    	listenerExecService = Executors.newFixedThreadPool(LISTENER_NUM_THREADS);
    	handlerExecService = Executors.newFixedThreadPool(EXECUTOR_NUM_THREADS);
        consumerConfig = consumerConfigFactory.getConsumerConfig();
        topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, CONSUMER_NUM_THREADS);
        mapper = new ObjectMapper();

        handlerTaskFactory = (String reply) -> new MiReplyTask(reply, mapper, sessions, template);

        super.start();
    }
}
package com.example.messaging.consumer;


import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import kafka.consumer.ConsumerConfig;

@Component
public class ConsumerConfigFactory {
	@Value("${zookeeperServer}")
    private String zkServer;
    
    private ConsumerConfig consumerConfig;

    @PostConstruct
    private void createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", zkServer);
        props.put("group.id", "Video-cg-0");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        consumerConfig = new ConsumerConfig(props);
    }

    public ConsumerConfig getConsumerConfig() {
        return consumerConfig;
    }
}
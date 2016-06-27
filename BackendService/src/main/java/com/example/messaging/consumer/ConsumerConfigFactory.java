package com.example.messaging.consumer;


import java.util.Properties;

import javax.annotation.PostConstruct;

import kafka.consumer.ConsumerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsumerConfigFactory {
	@Value("${zookeeperServer}")
    private String zkServer;
    
    private ConsumerConfig consumerConfig;

    @PostConstruct
    private void createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", zkServer);
        props.put("group.id", "Video-cg");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        consumerConfig = new ConsumerConfig(props);
    }

    public ConsumerConfig getConsumerConfig() {
        return consumerConfig;
    }
}
package com.example.broker.consumer;

import static kafka.consumer.Consumer.createJavaConsumerConnector;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public abstract class AbstractConcurrentConsumerService {
	public abstract ExecutorService getListenerExecService();
	public abstract ExecutorService getHandlerExecService();
	public abstract Function<String, Runnable> getHandlerTaskFactory(String topic);
	
	public abstract ConsumerConfig getConsumerConfig();
	public abstract Map<String, Integer> getTopicCountMap();
	
	public void start() {
		ConsumerConnector consumer = createJavaConsumerConnector(getConsumerConfig());
        
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(getTopicCountMap());
        for(Map.Entry<String, List<KafkaStream<byte[], byte[]>>> entry : consumerMap.entrySet()) {
        	List<KafkaStream<byte[], byte[]>> streams = entry.getValue();
        	int threadNumber = 0;
            for (final KafkaStream<byte[], byte[]> stream : streams) {
            	getListenerExecService().submit(
            			new ConsumerListenTask(stream, threadNumber,
            					getHandlerTaskFactory(entry.getKey()), 
            					getHandlerExecService()));
                threadNumber++;
            }
        }
    }
}

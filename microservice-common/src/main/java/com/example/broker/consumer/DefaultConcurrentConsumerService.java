package com.example.broker.consumer;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

import kafka.consumer.ConsumerConfig;

public class DefaultConcurrentConsumerService extends AbstractConcurrentConsumerService {
	protected ExecutorService listenerExecService;
	protected ExecutorService handlerExecService;
	protected Function<String, Runnable> handlerTaskFactory;
	protected ConsumerConfig consumerConfig;
	protected Map<String, Integer> topicCountMap;
	
	public DefaultConcurrentConsumerService() {
		super();
	}

	public DefaultConcurrentConsumerService(ExecutorService listenerExecService, ExecutorService handlerExecService,
			Function<String, Runnable> handlerTaskFactory, ConsumerConfig consumerConfig,
			Map<String, Integer> topicCountMap) {
		super();
		this.listenerExecService = listenerExecService;
		this.handlerExecService = handlerExecService;
		this.handlerTaskFactory = handlerTaskFactory;
		this.consumerConfig = consumerConfig;
		this.topicCountMap = topicCountMap;
	}

	@Override
	public ExecutorService getListenerExecService() {
		return listenerExecService;
	}

	@Override
	public ExecutorService getHandlerExecService() {
		return handlerExecService;
	}

	@Override
	public Function<String, Runnable> getHandlerTaskFactory(String topic) {
		return handlerTaskFactory;
	}

	@Override
	public ConsumerConfig getConsumerConfig() {
		return consumerConfig;
	}

	@Override
	public Map<String, Integer> getTopicCountMap() {
		return topicCountMap;
	}

	public Function<String, Runnable> getHandlerTaskFactory() {
		return handlerTaskFactory;
	}

	public void setHandlerTaskFactory(Function<String, Runnable> handlerTaskFactory) {
		this.handlerTaskFactory = handlerTaskFactory;
	}

	public void setListenerExecService(ExecutorService listenerExecService) {
		this.listenerExecService = listenerExecService;
	}

	public void setHandlerExecService(ExecutorService handlerExecService) {
		this.handlerExecService = handlerExecService;
	}

	public void setConsumerConfig(ConsumerConfig consumerConfig) {
		this.consumerConfig = consumerConfig;
	}

	public void setTopicCountMap(Map<String, Integer> topicCountMap) {
		this.topicCountMap = topicCountMap;
	}
}

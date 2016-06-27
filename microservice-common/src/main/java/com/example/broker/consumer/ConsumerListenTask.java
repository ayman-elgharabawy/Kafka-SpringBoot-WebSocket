package com.example.broker.consumer;


import java.util.concurrent.ExecutorService;
import java.util.function.Function;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerListenTask implements Runnable {
	private Function<String, Runnable> executorTaskFactory;
	private ExecutorService executorPool; 
    private KafkaStream<byte[], byte[]> kafkaStream;
    private int threadNumber;
 
	public ConsumerListenTask(KafkaStream<byte[], byte[]> kafkaStream, int threadNumber, 
			Function<String, Runnable> executorTaskFactory, ExecutorService executorPool) {
        this.threadNumber = threadNumber;
        this.kafkaStream = kafkaStream;
        this.executorTaskFactory = executorTaskFactory;
        this.executorPool = executorPool;
    }
    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
        
        while (it.hasNext()) {
            byte[] messageData = it.next().message();
            String reply    = new String(messageData);
            executorPool.submit(executorTaskFactory.apply(reply));
            System.out.println("Consumed Thread:" + threadNumber + ".Consuming User: " + reply);
        }
        System.out.println("Shutting down Thread: " + kafkaStream);
    }
}

package com.example.broker.producer;

import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class BasicKafkaProducerWrapper {
	protected Producer<String, String> producer;
	
	public Future<Void> send(String topic, String message) {
		ProducerRecord<String, String> record = new ProducerRecord<>(topic, "1", message);

		final CompletableFuture<Void> result = new CompletableFuture<>();
		producer.send(record, (RecordMetadata recordMetadata, Exception e) -> {
			if (e != null) {
				result.completeExceptionally(e);
			} else {
				result.complete(null);
			}
		});
		return result;
	}
	
	protected void init(Properties kafkaProps) {
		producer = new KafkaProducer<>(kafkaProps);
	}
}

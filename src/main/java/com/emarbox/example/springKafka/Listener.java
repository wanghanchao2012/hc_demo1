package com.emarbox.example.springKafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaListener(topics = { "test11www" }, containerFactory = "kafkaListenerContainerFactory")
	public void listen(ConsumerRecord<?, ?> record) {
		logger.info("kafka的key: " + record.key());
		logger.info("kafka的value: " + record.value().toString());
	}
}
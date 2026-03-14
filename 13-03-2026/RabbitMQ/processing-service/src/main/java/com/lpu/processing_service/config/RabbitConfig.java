package com.lpu.processing_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	
	public static final String QUEUE_NAME="Recharge_Queue"; // routing-key of the message service
	
	
	
	
	@Bean
	public  Queue queue() {
		return new Queue(QUEUE_NAME,true); // true -> even if consumer server is off it sends the message through the queue
		//false-> does not send data if server if off and message can be lost if server restarted
		// QUEUE_NAME -> is the name of the MQ
	}
	
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}

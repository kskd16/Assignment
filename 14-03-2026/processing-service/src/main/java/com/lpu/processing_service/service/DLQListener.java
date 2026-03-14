package com.lpu.processing_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lpu.processing_service.config.RabbitConfig;


//@Component
public class DLQListener {
	
	
	@RabbitListener(queues = RabbitConfig.DLQ_NAME)
	public void dlqMessage(String message) {
		System.out.println("Amount Value is invalid "+message);
		
	}

}

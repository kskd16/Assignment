package com.lpu.processing_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.lpu.processing_service.config.RabbitConfig;
import com.lpu.processing_service.dto.RequestMessageDto;

@Service
public class ProcessingService {
	
	
	
	@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
	public void receiveMessage(RequestMessageDto message) {
		System.out.println("Recharge message received for "+message.getMobileNumber() +" for amount "+message.getAmount()+ " on service provider "+message.getOperator());
	
	}
	

}

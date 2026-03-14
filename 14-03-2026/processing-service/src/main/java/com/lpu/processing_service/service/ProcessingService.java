package com.lpu.processing_service.service;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.lpu.processing_service.config.RabbitConfig;
import com.lpu.processing_service.dto.RequestMessageDto;

@Service
public class ProcessingService {

	@RabbitListener(queues = RabbitConfig.Recharge_queue)
	public void recieveMessage(RequestMessageDto message) {
		
		
		System.out.println("Recharge Message recieved for "+message.getMobileNumber());
	}
	
	@RabbitListener(queues = RabbitConfig.Payment_queue)
	public void recievePaymentMessage(String amount) {

	    System.out.println("Payment processing with amount " + amount);

	    if(!amount.equals("100")){
	        System.out.println("Amount is not 100. Sending to DLQ.");
	        return;
	    }

	    System.out.println("Payment successful");
	}
}
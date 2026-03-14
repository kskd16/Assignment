package com.lpu.recharge_service.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.lpu.recharge_service.config.RabbitConfig;
import com.lpu.recharge_service.dto.RequestMessageDto;

@Service
public class RechargeService {
	
	private final RabbitTemplate rabbitTemplate; // in-built class used to send message to the RabbitMQ
	
	public RechargeService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate= rabbitTemplate;
	}
	
	public String sendRequest(RequestMessageDto message) {
		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
		return "Recharge request sent to Queue";
	}
}

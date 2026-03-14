package com.lpu.processing_service.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	public static final String Recharge_queue = "Recharge_Queue";
	public static final String Payment_queue = "Payment_Queue";
	public static final String DLQ_NAME="DL_Queue";
	public static final String DLQ_Exchange = "DL_Queue_Exchange";
	public static final String DLQ_Key = "DL_Queue_Key";
	
	
	
	@Bean
	public Queue paymentQueue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-message-ttl",10000);
		args.put("x-dead-letter-exchange",DLQ_Exchange);
		args.put("x-dead-letter-routing-key",DLQ_Key);
		
		return new Queue(Payment_queue,true, false, false, args);
		
	}
	
	
	
	
	@Bean
	public Queue dlq() {
		return new Queue(DLQ_NAME, true);
	}
	@Bean
	public DirectExchange dlqExchange() {
		return new DirectExchange(DLQ_Exchange);
	}
	 @Bean
	    public Binding dlqBinding() {
	        return BindingBuilder
	                .bind(dlq())
	                .to(dlqExchange())
	                .with(DLQ_Key);
	    }

	
	@Bean
	public Queue queue() {
		return new Queue(Recharge_queue, true); // false ka mtlb hai jb payemnt on ho jaega tab jaega message, agr true hota toh bina on hue bhi message jata usse
	}
	
//	@Bean
//	public Queue queue2() {
//		return new Queue(Payment_queue, true); // false ka mtlb hai queue temporary, and true par queue persistent hai(server restart par bhi rahegi)
//	}
	
	@Bean
	public MessageConverter jsonMessageConverter() { // it will convert producer java message to json and save it to queue. And same happens when it will reach consumer.
		return new Jackson2JsonMessageConverter();
	}
	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setObservationEnabled(true);   // ADD HERE

        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setObservationEnabled(true);   // ADD HERE

        return factory;
    }

}
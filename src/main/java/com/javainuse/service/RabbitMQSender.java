package com.javainuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${absa.validated.payment.exchange}")
	private String absaValidatedPaymentExchange;
	
	@Value("${absa.validated.payment.routingkey}")
	private String absaValidatedPaymentRoutingKey;
	
	public void send(String absaMessageRequest) {
		Object s = amqpTemplate.convertSendAndReceive(absaValidatedPaymentExchange, absaValidatedPaymentRoutingKey, absaMessageRequest);
		System.out.println("Send msg = " + absaMessageRequest);
		System.out.println("Received msg = " + s);

	}
}
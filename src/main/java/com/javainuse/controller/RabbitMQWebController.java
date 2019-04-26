package com.javainuse.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javainuse.service.RabbitMQSender;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/absa-spring-example/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer/sendPayment")
	public String sendPayment() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("absa-spring-boot-request.txt");
		String requestMT1O1 = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		System.out.println(requestMT1O1);


		rabbitMQSender.send(requestMT1O1);

		return "Message sent to the RabbitMQ ABSA Queue Successfully";
	}

}


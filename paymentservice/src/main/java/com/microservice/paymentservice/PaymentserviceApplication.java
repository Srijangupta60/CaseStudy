package com.microservice.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class PaymentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentserviceApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

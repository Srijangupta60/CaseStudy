package com.microservice.paymentservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.paymentservice.model.TransactionDetails;
import com.microservice.paymentservice.service.PaymentService;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {
	
	private static final String END_POINT_PATH ="/payment";
	
	
	
	@Autowired 
	private MockMvc mockMvc;
	
	//private final Order order;
	
	@Autowired 
	private ObjectMapper objectMapper;
	
	@MockBean private  PaymentService paymentService;
	
	@Test
	public void testAddShoulReturn400BadRequest() throws JsonProcessingException {	
		
		TransactionDetails newtransactionaldetails = new TransactionDetails().builder().paymentMode("").referenceNumber("").amount(0).build();
		
		String requestBody = objectMapper.writeValueAsString(newtransactionaldetails);
	
	
	}

}

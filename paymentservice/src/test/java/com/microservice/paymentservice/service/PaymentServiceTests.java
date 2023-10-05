package com.microservice.paymentservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.microservice.paymentservice.controller.PaymentController;
import com.microservice.paymentservice.model.TransactionDetails;
import com.microservice.paymentservice.payload.PaymentRequest;
import com.microservice.paymentservice.payload.PaymentResponse;
import com.microservice.paymentservice.repository.TransactionDetailsRepository;
import com.microservice.paymentservice.utils.PaymentMode;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTests {
	
	
	@InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private TransactionDetailsRepository transactionDetailsRepository;

    @Test
    public void testDoPayment() {
        // Create a PaymentRequest object for testing
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(123);
        paymentRequest.setAmount(100);
        paymentRequest.setReferenceNumber("REF123");
        paymentRequest.setPaymentMode(PaymentMode.CREDIT_CARD);

        // Mock the behavior of the transactionDetailsRepository
        when(transactionDetailsRepository.save(any(TransactionDetails.class))).thenReturn(new TransactionDetails());

        // Call the method being tested
        long expectedTransactionId = 12345L;
        long transactionId = paymentService.doPayment(paymentRequest);

        // Assert the result
        assertEquals(expectedTransactionId, transactionId);
    }

    @Test
    public void testGetPaymentDetailsByOrderId() {
        // Mock the behavior of the transactionDetailsRepository
        when(transactionDetailsRepository.findByOrderId(anyLong())).thenReturn(Optional.of(new TransactionDetails()));

        // Call the method being tested
        PaymentResponse paymentResponse = paymentService.getPaymentDetailsByOrderId(123);

        // Assert the result
        assertNotNull(paymentResponse);
    }
}
	    

	



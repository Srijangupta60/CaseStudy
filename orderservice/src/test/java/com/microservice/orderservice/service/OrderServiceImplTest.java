//package com.microservice.orderservice.service;
//
//
//import com.microservice.orderservice.exception.OrderServiceCustomException;
//import com.microservice.orderservice.external.client.PaymentService;
//import com.microservice.orderservice.external.client.ProductService;
//import com.microservice.orderservice.model.Order;
//import com.microservice.orderservice.payload.request.OrderRequest;
//import com.microservice.orderservice.payload.request.PaymentRequest;
//import com.microservice.orderservice.payload.response.OrderResponse;
//import com.microservice.orderservice.payload.response.PaymentResponse;
//import com.microservice.orderservice.repository.OrderRepository;
//import com.microservice.orderservice.service.impl.OrderServiceImpl;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import java.time.Instant;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*; 
//
//public class OrderServiceImplTest {
//	
//	@Mock
//    private OrderRepository orderRepository;
//
//    @Mock
//    private ProductService productService;
//
//    @Mock
//    private PaymentService paymentService;
//
//    @InjectMocks
//    private OrderServiceImpl orderService;
//    
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//    
//    
//    @Test
//    void testPlaceOrder_SuccessfulPayment() {
//        // Mock data and behaviors
//        OrderRequest orderRequest = new OrderRequest();
//        orderRequest.setProductId(123); // Set the product ID to 123
//        orderRequest.setQuantity(2);    // Set the quantity to 2
//        orderRequest.setTotalAmount(50);
//        long orderId = 1L;
//        
//        PaymentResponse paymentResponse = new PaymentResponse();
//        paymentResponse.setPaymentId(12345); // Set payment ID to 12345
//        paymentResponse.setStatus("SUCCESS"); // Set status to "SUCCESS"
//        paymentResponse.setPaymentDate(Instant.now());
//
//        
//        
//        //when(productService.reduceQuantity(any(Long.class), any(Long.class))).thenReturn(true);
//        when(productService.reduceQuantity(any(Long.class), any(Long.class)))
//        .thenReturn(ResponseEntity.ok().build());
//        when(orderRepository.save(any(Order.class))).thenReturn(new Order(orderId, orderId, orderId, null, null, orderId));
//        when(paymentService.doPayment(any(PaymentRequest.class)))
//        .thenReturn(ResponseEntity.ok(123L));
//        
//        // Test the placeOrder method
//        long resultOrderId = orderService.placeOrder(orderRequest);
//
//        // Verify interactions and results
//        verify(productService, times(1)).reduceQuantity(any(Long.class), any(Long.class));
//        verify(orderRepository, times(1)).save(any(Order.class));
//        verify(paymentService, times(1)).doPayment(any(PaymentRequest.class));
//        assert resultOrderId == orderId;
//    }
//    
//    @Test
//    void testGetOrderDetails_OrderNotFound() {
//        // Mock data and behaviors
//        long orderId = 1;
//
//        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());
//
//        // Test the getOrderDetails method and expect an exception
//        assertThrows(OrderServiceCustomException.class, () -> orderService.getOrderDetails(orderId));
//
//        // Verify interactions
//        verify(orderRepository, times(1)).findById(orderId);
//    }
//    
//    @Test
//    void testGetOrderDetails() {
//        // Mock data and behaviors
//        long orderId = 1L;
//        Order mockOrder = new Order(/* initialize with required data */);
//        ProductResponse mockProductResponse = new ProductResponse(/* initialize with required data */);
//        PaymentResponse mockPaymentResponse = new PaymentResponse(/* initialize with required data */);
//
//        when(orderRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));
//        when(restTemplate.getForObject(anyString(), eq(ProductResponse.class))).thenReturn(mockProductResponse);
//        when(restTemplate.getForObject(anyString(), eq(PaymentResponse.class))).thenReturn(mockPaymentResponse);
//
//        // Test the getOrderDetails method
//        OrderResponse resultOrderResponse = orderService.getOrderDetails(orderId);
//
//        // Verify interactions and results
//        verify(orderRepository, times(1)).findById(orderId);
//        verify(restTemplate, times(1)).getForObject(anyString(), eq(ProductResponse.class));
//        verify(restTemplate, times(1)).getForObject(anyString(), eq(PaymentResponse.class));
//
//        // Add assertions to verify the content of resultOrderResponse
//        // You'll need to compare it with the expected mock data
//    }
//
//
//
//    
//    
//	
//
//}

package com.microservice.productservice.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.microservice.productservice.controller.ProductController;
//import com.microservice.productservice.payload.request.ProductRequest;
//import com.microservice.productservice.payload.response.ProductResponse;
//import com.microservice.productservice.service.ProductService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
////import org.springframework.mock.web.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
////import org.springframework.test.web.servlet.MockMvcBuilders;
//
//import org.springframework.test.web.servlet.MockMvc;
//
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.microservice.productservice.controller.ProductController;
//import com.microservice.productservice.payload.request.ProductRequest;
//import com.microservice.productservice.payload.response.ProductResponse;
//import com.microservice.productservice.service.ProductService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





public class ProductControllerTest {
	
	
//	private MockMvc mockMvc;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @Mock
//    private ProductService productService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//    
//    @Test
//    public void testAddProduct() throws Exception {
//    
//    	 ProductRequest request = new ProductRequest();
//         request.setName("Test Product");
//         request.setQuantity(10);
//         request.setPrice(100);
//         ObjectMapper objectMapper = new ObjectMapper();
//         String requestJson = objectMapper.writeValueAsString(request);
//
//         // Mock the service's behavior for adding a product
//         when(productService.addProduct(any(ProductRequest.class))).thenReturn(1L);
//
//         // Perform a POST request to /product
//         mockMvc.perform(post("/product")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(requestJson))
//                 .andExpect(status().isCreated())
//                 .andExpect(jsonPath("$.productId").value(1));
//
//         // Verify that the productService.addProduct method was called once with the expected arguments
//         verify(productService, times(1)).addProduct(any(ProductRequest.class));
//    	 
//    }
//    

    
		

}

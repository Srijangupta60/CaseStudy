package com.microservice.productservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.microservice.productservice.entity.Product;
import com.microservice.productservice.exception.ProductServiceCustomException;
import com.microservice.productservice.payload.request.ProductRequest;
import com.microservice.productservice.payload.response.ProductResponse;
import com.microservice.productservice.repository.ProductRepository;
import com.microservice.productservice.service.impl.ProductServiceImpl;
import com.microservice.productservice.payload.request.ProductRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;



public class ProductServiceTest {
	
	
	@InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    
    @Test
    public void testAddProduct() {
        // Create a ProductRequest object
        ProductRequest request = new ProductRequest();
        request.setName("Test Product");
        request.setQuantity(10);
        request.setPrice(100);

        // Mock the repository's behavior when saving a product
        Product savedProduct = new Product();
        savedProduct.setProductId(1L);
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        // Call the service method
        long productId = productService.addProduct(request);

        // Assertions
        assertEquals(1L, productId);
    }
    
    @Test
    public void testGetProductById() {
        // Mock the repository's behavior when finding a product by ID
        Product product = new Product();
        product.setProductId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Call the service method
        ProductResponse response = productService.getProductById(1L);

        // Assertions
        assertEquals(1L, response.getProductId());
    }
    
    @Test
    public void testReduceQuantitySufficientQuantity() {
        // Mock the repository's behavior when finding a product by ID
        Product product = new Product();
        product.setProductId(1L);
        product.setQuantity(10);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Call the service method to reduce quantity
        productService.reduceQuantity(1L, 5);

        // Assertions
        assertEquals(5, product.getQuantity());
        verify(productRepository, times(1)).save(product);
    }
    
    
    @Test
    public void testReduceQuantityInsufficientQuantity() {
        // Mock the repository's behavior when finding a product by ID
        Product product = new Product();
        product.setProductId(1L);
        product.setQuantity(2); // Insufficient quantity

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Call the service method to reduce quantity
        assertThrows(ProductServiceCustomException.class, () -> {
            productService.reduceQuantity(1L, 5);
        });

        // Verify that productRepository.save() is never called in this case
        verify(productRepository, never()).save(product);
    }
    
    @Test
    public void testDeleteProductById() {
        // Mock the repository's behavior to check product existence
        when(productRepository.existsById(1L)).thenReturn(true);

        // Call the service method to delete a product
        productService.deleteProductById(1L);

        // Verify that productRepository.deleteById() is called with the correct ID
        verify(productRepository, times(1)).deleteById(1L);
    }
    
    @Test
    public void testDeleteProductByIdProductNotFound() {
        // Mock the repository's behavior to check product existence
        when(productRepository.existsById(1L)).thenReturn(false);

        // Call the service method to delete a product that doesn't exist
        assertThrows(ProductServiceCustomException.class, () -> {
            productService.deleteProductById(1L);
        });

        // Verify that productRepository.deleteById() is never called in this case
        verify(productRepository, never()).deleteById(1L);
    }
   
    
    
    
	
	
	
	

}

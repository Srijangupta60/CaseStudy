package com.microservice.productservice.payload.request;

import lombok.Builder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;
}
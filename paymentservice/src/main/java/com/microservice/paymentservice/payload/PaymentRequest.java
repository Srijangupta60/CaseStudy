package com.microservice.paymentservice.payload;

import com.microservice.paymentservice.utils.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest {

    private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
	

}
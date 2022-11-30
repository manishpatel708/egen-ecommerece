package com.example.ecommerce.dto;

import java.util.List;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	@NonNull
	private String customerId;

	@NonNull
	private double subTotal;

	@NonNull
	private double totalAmt;

	@NonNull
	private double tax;

	@NonNull
	private double shippingCharges;

	@NonNull
	private String title;

	@NonNull
	private String shippingMode;

	@NonNull
	private double amount;

	@NonNull
	private String paymentMode;

	@NonNull
	private AddressDto billingAddress;

	@NonNull
	private AddressDto shippingAddress;

	@NonNull
	private List<OrderItemDto> orderItems;
}

package com.example.ecommerce.dto;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateResponse {

	@NonNull
	private long orderId;

	@NonNull
	private String orderStatus;

}

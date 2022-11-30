package com.example.ecommerce.dto;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	@NonNull
	private String sku;

	@NonNull
	private String title;

	@NonNull
	private String description;

	@NonNull
	private double price;

}

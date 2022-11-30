package com.example.ecommerce.dto;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	@NonNull
	private String address1;

	@NonNull
	private String address2;

	@NonNull
	private String city;

	@NonNull
	private String state;

	@NonNull
	private String zip;

	@NonNull
	private String email;

	@NonNull
	private String phone;

}

package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/products")
	@Operation(summary = "Create a product", description = "Create a product")
	public ResponseEntity<Product> createOrder(@RequestBody ProductDto productDto) {
		log.info("Controller :: {}", productDto);
		return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
	}

	@GetMapping("/products/{productId}")
	@Operation(summary = "Get a product", description = "Get a product")
	public Product getProduct(@PathVariable(name = "productId") String productId) {
		return productService.getProduct(productId);
	}

}

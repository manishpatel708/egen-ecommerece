package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	@Operation(summary = "Get a all product", description = "Get a all product")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@PostMapping
	@Operation(summary = "Create a new product", description = "Create a new product")
	public ResponseEntity<Product> createOrder(@RequestBody ProductDto productDto) {
		log.info("Controller :: {}", productDto);
		return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
	}

	@GetMapping("/{productId}")
	@Operation(summary = "Get a product", description = "Get a product by id")
	public ResponseEntity<Product> getProduct(@PathVariable(name = "productId") long productId) {
		return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.CREATED);
	}

	@DeleteMapping("/{productId}")
	@Operation(summary = "Delete a product", description = "Delete a product by id")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "productId") long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product deleted....", HttpStatus.OK);
	}

	@PutMapping("/{productId}")
	@Operation(summary = "Update a product", description = "Update a product ")
	public ResponseEntity<Product> updateOrder(@RequestBody ProductDto productDto,
			@PathVariable(name = "productId") long productId) {
		return new ResponseEntity<>(productService.updateProduct(productId, productDto), HttpStatus.OK);
	}

}

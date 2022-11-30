package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;

public interface ProductService {

	public Product createProduct(ProductDto productDto);

	public Product getProduct(String productId);
}

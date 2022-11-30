package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;

public interface ProductService {

	public Product createProduct(ProductDto productDto);

	public Product getProduct(long productId);

	public List<Product> getAllProduct();

	public void deleteProduct(long productId);

	public Product updateProduct(long productId, ProductDto productDto);
}

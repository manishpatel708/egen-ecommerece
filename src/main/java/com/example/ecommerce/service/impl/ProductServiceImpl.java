package com.example.ecommerce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public Product createProduct(ProductDto productDto) {
		log.info("Creating Product {}", productDto);
		Product mappedProduct = modelMapper.map(productDto, Product.class);
		return productRepository.save(mappedProduct);
	}

	@Override
	public Product getProduct(String productId) {
		log.info("Get Product by productId {}", productId);
		return productRepository.findById(productId).orElseThrow();
	}

}

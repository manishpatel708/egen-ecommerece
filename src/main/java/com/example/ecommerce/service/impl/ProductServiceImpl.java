package com.example.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

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
	public Product getProduct(long productId) {
		log.info("Get Product by productId {}", productId);
		return productRepository.findById(productId).orElseThrow();
	}

	@Override
	public List<Product> getAllProduct() {
		log.info("Get All Product {}");
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(long productId) {
		log.info("delete Product {}", productId);
		productRepository.deleteById(productId);

	}

	@Override
	public Product updateProduct(long productId, ProductDto productDto) {
		log.info("update Product {}", productDto);
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product oldProduct = optional.get();
			oldProduct.setSku(productDto.getSku());
			oldProduct.setDescription(productDto.getDescription());
			oldProduct.setPrice(productDto.getPrice());
			oldProduct.setTitle(productDto.getTitle());
			return productRepository.save(oldProduct);
		} else {
			throw new NotFoundException("data is not available for update");
		}
	}

}

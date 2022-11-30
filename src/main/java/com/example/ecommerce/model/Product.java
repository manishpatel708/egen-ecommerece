package com.example.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ecommerce_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "sku", nullable = false)
	private String sku;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@CreationTimestamp
	@Column(name = "createdAt", nullable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(name = "updatedAt", nullable = false)
	private LocalDate updatedAt;

//	@OneToMany(targetEntity = OrderItem.class, fetch = FetchType.LAZY, mappedBy = "product")
//	private List<OrderItem> orderItems;

}
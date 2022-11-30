package com.example.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class OrderItemPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "product_id", nullable = false)
	private Long productId;

	@Column(name = "order_id", nullable = false)
	private Long orderId;

}

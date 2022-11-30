package com.example.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ecommerce_payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", nullable = false, unique = true)
	private Long paymentId;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "payment_mode", nullable = false)
	private String paymentMode;

	@Column(name = "confirmation_number", nullable = false)
	private String confirmationNumber;

	@Column(name = "payment_status", nullable = false)
	private String paymentStatus;

	@CreationTimestamp
	@Column(name = "createdAt", nullable = false)
	private LocalDate createdAt;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
	private Order order;

}

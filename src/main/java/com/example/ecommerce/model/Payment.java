package com.example.ecommerce.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

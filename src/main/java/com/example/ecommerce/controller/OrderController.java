package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.OrderCreateResponse;
import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	@Operation(summary = "Create an order", description = "Create an order")
	public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody @Valid OrderDto orderDto) {
		return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<OrderDto> findOrderById(@PathVariable(name = "orderId") String orderId) {
		return new ResponseEntity<>(orderService.findOrderById(orderId), HttpStatus.OK);
	}

	@PutMapping("/orders/{orderId}")
	public void updateOrderStatus(@PathVariable("orderId") @NotNull String orderId,
			@RequestParam(name = "orderStatus") String orderStatus) throws Exception {
		orderService.updateOrderStatus(orderId, orderStatus);
	}

}

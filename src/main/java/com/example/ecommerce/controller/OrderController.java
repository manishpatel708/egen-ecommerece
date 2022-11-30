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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.OrderCreateResponse;
import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	@Operation(summary = "Create an order", description = "Create an order")
	public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/{orderId}")
	@Operation(summary = "Find an order by ID", description = "Find an order by ID")
	public ResponseEntity<OrderDto> findOrderById(@PathVariable(name = "orderId") long orderId) {
		return new ResponseEntity<>(orderService.findOrderById(orderId), HttpStatus.OK);
	}

	@PutMapping("/{orderId}")
	@Operation(summary = "Update an order", description = "Update an order")
	public void updateOrderStatus(@PathVariable("orderId") long orderId,
			@RequestParam(name = "orderStatus") String orderStatus) throws Exception {
		orderService.updateOrderStatus(orderId, orderStatus);
	}
	
	@DeleteMapping("/{orderId}")
	@Operation(summary = "Update an order", description = "Update an order")
	public void deleteOrder(@PathVariable("orderId") long orderId)  {
		orderService.deleteOrder(orderId);
	}
	
	@GetMapping
	@Operation(summary = "Get all order", description = "Get all order")
	public ResponseEntity<List<Order>> getAllOrder() {
		return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
	}

}

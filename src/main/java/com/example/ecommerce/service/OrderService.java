package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderCreateResponse;
import com.example.ecommerce.dto.OrderDto;

public interface OrderService {

	public void updateOrderStatus(String orderId, String orderStatus) throws Exception;

	public OrderDto findOrderById(String orderId);

	public OrderCreateResponse createOrder(OrderDto orderDto);
}

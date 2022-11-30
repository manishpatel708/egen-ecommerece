package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.dto.OrderCreateResponse;
import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.model.Order;

public interface OrderService {

	public void updateOrderStatus(long orderId, String orderStatus) throws Exception;

	public OrderDto findOrderById(long orderId);

	public OrderCreateResponse createOrder(OrderDto orderDto);

	public List<Order> getAllOrder();

	public void deleteOrder(long orderId);
}

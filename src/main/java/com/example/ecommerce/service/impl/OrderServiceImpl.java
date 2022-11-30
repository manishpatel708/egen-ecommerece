package com.example.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.example.ecommerce.dto.OrderCreateResponse;
import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.enumData.OrderStatus;
import com.example.ecommerce.mapper.OrderDetailsMapper;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailsMapper orderDetailsMapper;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	public void updateOrderStatus(long orderId, String orderStatus) throws Exception {
		log.info("update order status{}", orderStatus);
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			order.setOrderStatus(orderStatus);
			orderRepository.save(order);
		} else {
			throw new NotFoundException(orderId + "is not present!");
		}
	}

	public OrderDto findOrderById(long orderId) {
		log.info("find Order By Id {}", orderId);
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			return modelMapper.map(optionalOrder.get(), OrderDto.class);
		} else {
			throw new NotFoundException(orderId + "is not present!");
		}
	}

	@Transactional
	public OrderCreateResponse createOrder(OrderDto orderDto) {
		log.info("Creating Order for customer {}", orderDto.getCustomerId());
		Order mappedOrder = modelMapper.map(orderDto, Order.class);
		mappedOrder.setPayment(orderDetailsMapper.buildAndLoadPayment(orderDto.getAmount(), orderDto.getPaymentMode()));
		mappedOrder.setOrderStatus(OrderStatus.RECEIVED.name());
		mappedOrder.setBillingAddress(orderDetailsMapper.buildAndLoadAddress(orderDto.getBillingAddress()));
		mappedOrder.setShippingAddress(orderDetailsMapper.buildAndLoadAddress(orderDto.getShippingAddress()));
		Order savedOrder = orderRepository.save(mappedOrder);

		log.info("savedOrder :: {}", savedOrder);
		List<OrderItem> orderItemList = orderDetailsMapper.buildOrderItems(orderDto.getOrderItems(),
				savedOrder.getOrderId());
		log.info("orderItemList :: {}", orderItemList.size());
		orderItemRepository.saveAll(orderItemList);
		return new OrderCreateResponse(savedOrder.getOrderId(), savedOrder.getOrderStatus());
	}

	@Override
	public List<Order> getAllOrder() {
		log.info("Get all Order {}");
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(long orderId) {
		log.info("delete Order {}", orderId);
		orderRepository.deleteById(orderId);
	}

}

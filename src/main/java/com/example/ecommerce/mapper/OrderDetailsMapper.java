package com.example.ecommerce.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ecommerce.dto.AddressDto;
import com.example.ecommerce.dto.OrderItemDto;
import com.example.ecommerce.enumData.PaymentStatus;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.OrderItemPk;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repository.AddressRepository;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.PaymentRepository;

@Component
public class OrderDetailsMapper {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	ModelMapper modelMapper;

	public Payment buildAndLoadPayment(double amount, @NotNull String paymentMode) {

		Payment payment = new Payment();

		String confirmationNumber = UUID.randomUUID().toString();
		String status = PaymentStatus.PROCESSING.name();

		payment.setAmount(amount);
		payment.setConfirmationNumber(confirmationNumber);
		payment.setPaymentMode(paymentMode);
		payment.setPaymentStatus(status);
		this.paymentRepository.save(payment);
		return payment;
	}

	public Address buildAndLoadAddress(AddressDto addressDto) {
		Address addressEntity = this.toAddressEntity(addressDto);
		Object var10000 = this.addressRepository.save(addressEntity);
		return (Address) var10000;
	}

	public List<OrderItem> buildOrderItems(List<OrderItemDto> orderItemsDtoList, long orderId) {
		List<OrderItem> list = new ArrayList<>();

		System.err.println("buildOrderItems :: orderId :: " + orderId);

		orderItemsDtoList.forEach(itemDto -> {
			System.err.println("buildOrderItems :: orderItemsDtoList :: " + itemDto);
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(null);
			orderItem.setProduct(null);
			orderItem.setOrderItemPk(new OrderItemPk(itemDto.getProductId(), orderId));
			orderItem.setQuantity(itemDto.getQuantity());
			list.add(orderItem);
			System.err.println("order item list :: " + orderItem);
		});

		return (List<OrderItem>) orderItemRepository.saveAll(list);

	}

	private Address toAddressEntity(AddressDto addressDto) {
		return modelMapper.map(addressDto, Address.class);
	}
}

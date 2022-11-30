package com.example.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.OrderItemPk;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, OrderItemPk> {

}

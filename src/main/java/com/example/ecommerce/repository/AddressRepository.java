package com.example.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}

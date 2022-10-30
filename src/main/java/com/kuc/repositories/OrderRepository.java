package com.kuc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kuc.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {}

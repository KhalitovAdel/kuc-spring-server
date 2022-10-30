package com.kuc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuc.dtos.OrderDto;
import com.kuc.entities.BuildType;
import com.kuc.entities.Order;
import com.kuc.repositories.OrderRepository;

@Service
public class OrderService {
    private OrderRepository repository;

    OrderService(@Autowired OrderRepository repository) {
        this.repository = repository;
    }

    public static class CreateOrder {
        int area;
        BuildType buildType;
        String fullName;
        Long userId;

        public CreateOrder(int area, BuildType buildType, String fullName, Long userId) {
            this.area = area;
            this.buildType = buildType;
            this.fullName = fullName;
            this.userId = userId;
        }
    }

    public Order create(CreateOrder dto) {
        Order order = new Order();

        return repository.save(order);
    }
}

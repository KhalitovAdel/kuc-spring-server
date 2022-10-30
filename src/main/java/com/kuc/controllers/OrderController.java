package com.kuc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuc.dtos.OrderDto;
import com.kuc.entities.Order;
import com.kuc.repositories.OrderRepository;
import com.kuc.services.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService service;
    private OrderRepository repository;

    OrderController(@Autowired OrderService service, @Autowired OrderRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    
    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody OrderDto.CreateOrderDto dto) {
        Order order = service.create(new OrderService.CreateOrder(
            dto.area,
            dto.buildType,
            dto.fullName,
            1L
        ));

        return new ResponseEntity<Order>(order, HttpStatus.CREATED);  
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> read(@PathVariable("id") Long id) {
        Optional<Order> order = repository.findById(id);

        return new ResponseEntity<Order>(order.orElseThrow(), HttpStatus.OK); 
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> list() {
        Iterable<Order> orders = repository.findAll();

        return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK); 
    }
    
}

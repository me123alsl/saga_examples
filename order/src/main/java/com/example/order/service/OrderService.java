package com.example.order.service;

import com.example.order.controller.dto.CreateOrderCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public ResponseEntity<?> createOrder(CreateOrderCommand createOrderCommand);
    public ResponseEntity<?> findAllOrders();

}

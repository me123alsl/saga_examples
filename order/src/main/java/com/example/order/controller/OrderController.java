package com.example.order.controller;

import com.example.order.controller.dto.CreateOrderCommand;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<?> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
    orderService.createOrder(createOrderCommand);
    return ResponseEntity.ok().build();
  }

}

package com.example.order.controller.dto;

import com.example.order.entity.Order;
import com.example.order.entity.OrderStatus;
import lombok.ToString;

@ToString
public class CreateOrderCommand {

  private Long productId;
  private int quantity;

  public Order toEntity() {
    return Order.builder()
        .productId(productId)
        .quantity(quantity)
        .status(OrderStatus.ORDERED)
        .build();
  }

}

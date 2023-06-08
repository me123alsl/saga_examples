package com.example.order.service.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderEvent {

  private Long orderId;
  private Long productId;
  private int quantity;

}

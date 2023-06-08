package com.example.order.entity;

import com.example.order.service.event.CreateOrderEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Builder @AllArgsConstructor
@Getter
@RequiredArgsConstructor
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long productId;

  private int quantity;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public CreateOrderEvent toCreateOrderEvent() {
    return CreateOrderEvent.builder()
        .orderId(id)
        .productId(productId)
        .quantity(quantity)
        .build();
  }

  public void cancel() {
    this.status = OrderStatus.CANCELLED;
  }

}

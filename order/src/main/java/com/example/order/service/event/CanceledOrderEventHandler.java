package com.example.order.service.event;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CanceledOrderEventHandler {

  private final OrderRepository orderRepository;

  @KafkaListener(topics = "#{'${kafka.topics.order.cancel}'}")
  public void handle(CancelOrderEvent cancelOrderEvent) {
    log.info("Order Canceled: " + cancelOrderEvent.getOrderId());
    cancelOrder(cancelOrderEvent.getOrderId());
  }

  /**
   * 주문 취소
   * @param orderId
   */
  public void cancelOrder(Long orderId) {
    log.info("Order Canceled: [{}]", orderId);
    orderRepository.findById(orderId).ifPresent(Order::cancel);
  }

}

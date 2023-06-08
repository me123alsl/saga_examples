package com.example.order.service.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateOrderEventHandler {

  private final KafkaTemplate kafkaTemplate;

  @Value("${kafka.order.create.topic}")
  private String createOrderTopic;

  public void handle(CreateOrderEvent createOrderEvent) {
    log.info("Order Created: " + createOrderEvent.getOrderId());
    kafkaTemplate.send(createOrderTopic, createOrderEvent);
  }
}

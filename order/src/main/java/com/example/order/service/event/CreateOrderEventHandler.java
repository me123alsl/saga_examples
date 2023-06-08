package com.example.order.service.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateOrderEventHandler {

  private final KafkaTemplate kafkaTemplate;

  @Value("${kafka.topics.order.create}")
  private final String createOrderTopic;

  public void handle(CreateOrderEvent createOrderEvent) {
    log.info("Order Created: " + createOrderEvent.getOrderId());
    kafkaTemplate.send(createOrderTopic, createOrderEvent);
  }
}

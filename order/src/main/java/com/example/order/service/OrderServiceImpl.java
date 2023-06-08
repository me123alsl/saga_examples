package com.example.order.service;

import com.example.order.controller.dto.CreateOrderCommand;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import com.example.order.service.event.CreateOrderEventHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final CreateOrderEventHandler createOrderEventHandler;

  /**
   * 주문 생성
   * @param createOrderCommand
   * @throws RuntimeException
   */
  @Override
  public ResponseEntity<?> createOrder(CreateOrderCommand createOrderCommand)
      throws RuntimeException {
    log.info("Order Created: [{}]", createOrderCommand);
    Order order = orderRepository.save(createOrderCommand.toEntity());
    createOrderEventHandler.handle(order.toCreateOrderEvent());
    return new ResponseEntity<Order>(order, null, HttpStatus.OK);
  }


  /**
   * 주문 목록 전체 조회
   * @throws RuntimeException
   */
  @Override
  public ResponseEntity<?> findAllOrders() throws RuntimeException {
    List<Order> findOrders = orderRepository.findAll();
    return findOrders.isEmpty() ? new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(findOrders, null, HttpStatus.OK);
  }

}

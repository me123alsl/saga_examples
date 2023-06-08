package com.example.order.repository;

import com.example.order.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  Order save(Order order);
  Optional<Order> findById(Long id);
  List<Order> findAll();
}

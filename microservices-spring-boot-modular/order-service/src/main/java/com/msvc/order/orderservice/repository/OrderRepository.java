package com.msvc.order.orderservice.repository;

import com.msvc.order.orderservice.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}

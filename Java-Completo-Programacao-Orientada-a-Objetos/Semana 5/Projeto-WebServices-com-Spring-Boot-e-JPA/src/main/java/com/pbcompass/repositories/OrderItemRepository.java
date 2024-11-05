package com.pbcompass.repositories;

import com.pbcompass.entities.OrderItem;
import com.pbcompass.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

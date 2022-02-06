package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

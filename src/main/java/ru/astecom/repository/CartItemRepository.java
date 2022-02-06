package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.CartItem;
import ru.astecom.models.Disk;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}

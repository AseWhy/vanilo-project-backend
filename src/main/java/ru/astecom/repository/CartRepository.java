package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Cart;
import ru.astecom.models.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}

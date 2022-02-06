package ru.astecom.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.astecom.models.Cart;
import ru.astecom.repository.CartRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class CartService extends BaseService<Cart, Long, CartRepository> {
    @Autowired
    protected UserService userService;

    public CartService() {
        super(Cart.class);
    }

    @Transactional
    public Cart getCartByUserId(@NotNull Long userId) {
        var user = userService.findById(userId);
        var cart = user.getCart();

        if(cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setUserId(userId);
        }

        return save(cart);
    }
}

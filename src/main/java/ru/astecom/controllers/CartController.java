package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ConvertMutator;
import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.DTO.cart_item.CreatorCartItemDTO;
import ru.astecom.models.Cart;
import ru.astecom.models.CartItem;
import ru.astecom.service.CartItemService;
import ru.astecom.service.CartService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/carts")
@PreAuthorize("isAuthenticated()")
public class CartController {
    @Autowired
    protected CartService cartService;
    @Autowired
    protected CartItemService cartItemService;

    @GetMapping("/{cartId}")
    public Cart restFindById(@PathVariable("cartId") @Valid Long cartId) {
        return cartService.restFindById(cartId);
    }

    @PostMapping("/{cartId}/items")
    public RestPage<CartItem> listCartItems(@PathVariable("cartId") @Valid Long cartId, @NoodleFilter @Valid NoodleRestFilter filter) {
        return cartItemService.listByCartId(cartId, filter);
    }

    @PutMapping("/{cartId}/items")
    public CartItem putCartItem(@PathVariable("cartId") @Valid Long cartId, @ConvertMutator @Valid CreatorCartItemDTO payload) {
        return cartItemService.addByCartId(cartId, payload);
    }

    @PostMapping
    public RestPage<Cart> listCart(@NoodleFilter @Valid NoodleRestFilter filter) {
        return cartService.restList(filter);
    }
}

package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ConvertMutator;
import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.DTO.cart_item.MutatorCartItemDTO;
import ru.astecom.models.CartItem;
import ru.astecom.service.CartItemService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/cart_items")
@PreAuthorize("isAuthenticated()")
public class CartItemController {
    @Autowired
    protected CartItemService cartItemService;

    @GetMapping("/{cartItemId}")
    public CartItem restFindById(@PathVariable("cartItemId") @Valid Long cartItemId) {
        return cartItemService.restFindById(cartItemId);
    }

    @PostMapping("/{cartItemId}")
    public CartItem editById(@PathVariable("cartItemId") @Valid Long cartItemId, @ConvertMutator @Valid MutatorCartItemDTO payload) {
        return cartItemService.editById(cartItemId, payload);
    }

    @DeleteMapping("/{cartItemId}")
    public CartItem restDeleteById(@PathVariable("cartItemId") @Valid Long cartItemId) {
        return cartItemService.restDeleteById(cartItemId);
    }

    @PostMapping
    public RestPage<CartItem> listCartItems(@NoodleFilter @Valid NoodleRestFilter filter) {
        return cartItemService.restList(filter);
    }
}

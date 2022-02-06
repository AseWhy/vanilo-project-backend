package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.OrderItem;
import ru.astecom.service.OrderItemService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/order_items")
@PreAuthorize("isAuthenticated()")
public class OrderItemController {
    @Autowired
    protected OrderItemService orderItemService;

    @GetMapping("/{orderItemId}")
    public OrderItem restFindById(@PathVariable("orderItemId") @Valid Long cartItemId) {
        return orderItemService.restFindById(cartItemId);
    }

    @DeleteMapping("/{orderItemId}")
    public OrderItem restDeleteById(@PathVariable("orderItemId") @Valid Long cartItemId) {
        return orderItemService.restDeleteById(cartItemId);
    }

    @PostMapping
    public RestPage<OrderItem> listCartItems(@NoodleFilter @Valid NoodleRestFilter filter) {
        return orderItemService.restList(filter);
    }
}

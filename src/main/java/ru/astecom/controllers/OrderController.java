package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.Order;
import ru.astecom.models.OrderItem;
import ru.astecom.service.OrderItemService;
import ru.astecom.service.OrderService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/orders")
@PreAuthorize("isAuthenticated()")
public class OrderController {
    @Autowired
    protected OrderService orderService;
    @Autowired
    protected OrderItemService orderItemService;

    @GetMapping("/{orderId}/items")
    public RestPage<OrderItem> restFindById(@PathVariable("orderId") @Valid Long orderId, @NoodleFilter @Valid NoodleRestFilter filter) {
        return orderItemService.listByOrderId(orderId, filter);
    }

    @GetMapping("/{orderId}")
    public Order restFindById(@PathVariable("orderId") @Valid Long orderId) {
        return orderService.restFindById(orderId);
    }

    @DeleteMapping("/{orderId}")
    public Order restDeleteById(@PathVariable("orderId") @Valid Long orderId) {
        return orderService.restDeleteById(orderId);
    }

    @PostMapping
    public RestPage<Order> listCartItems(@NoodleFilter @Valid NoodleRestFilter filter) {
        return orderService.restList(filter);
    }
}

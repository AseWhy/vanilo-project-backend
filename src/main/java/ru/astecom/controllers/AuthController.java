package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ConvertMutator;
import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.DTO.user.AuthDTO;
import ru.astecom.DTO.user.UserLoginDTO;
import ru.astecom.DTO.user.UserRegistrationDTO;
import ru.astecom.models.Cart;
import ru.astecom.models.Order;
import ru.astecom.models.User;
import ru.astecom.secure.Helper;
import ru.astecom.secure.JwtProvider;
import ru.astecom.service.CartService;
import ru.astecom.service.OrderService;
import ru.astecom.service.UserService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected JwtProvider jwtProvider;
    @Autowired
    protected CartService cartService;
    @Autowired
    protected OrderService orderService;

    @PostMapping("/register")
    public User registerUser(@ConvertMutator @Valid UserRegistrationDTO payload) {
        return userService.register(payload);
    }

    @PostMapping("/auth")
    public AuthDTO auth(@ConvertMutator @NotNull UserLoginDTO payload) {
        return jwtProvider.generateToken(payload.getLogin(), payload.getPassword());
    }

    @GetMapping("/current")
    @PreAuthorize("isAuthenticated()")
    public User current() {
        return Helper.getPresentInvoker().getUser();
    }

    @GetMapping("/current/cart")
    @PreAuthorize("isAuthenticated()")
    public Cart currentCart() {
        return cartService.getCartByUserId(Helper.getPresentInvoker().getId());
    }

    @GetMapping("/current/orders")
    @PreAuthorize("isAuthenticated()")
    public RestPage<Order> currentOrders(@NoodleFilter @Valid NoodleRestFilter filter) {
        return orderService.getOrdersByUser(Helper.getPresentInvoker().getId(), filter);
    }

    @PutMapping("/current/orders")
    @PreAuthorize("isAuthenticated()")
    public Order createOrder() {
        return orderService.createOrder(Helper.getPresentInvoker().getId());
    }
}

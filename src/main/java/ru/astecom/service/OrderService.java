package ru.astecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.exceptions.base.CustomException;
import ru.astecom.models.Order;
import ru.astecom.models.OrderItem;
import ru.astecom.repository.OrderRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class OrderService extends BaseService<Order, Long, OrderRepository> {
    @Autowired
    protected UserService userService;
    @Autowired
    protected CartService cartService;

    public OrderService() {
        super(Order.class);
    }

    /**
     * Получить страницу заказов для пользователя
     *
     * @param id идентификатор пользователя
     * @param filter фильтер для заказов
     * @return страница заказов пользователя
     */
    public RestPage<Order> getOrdersByUser(Long id, NoodleRestFilter filter) {
        return restList(filter.and(condition -> condition.where("userId", id)));
    }

    /**
     * Создать заказ и текущей корзины
     *
     * @param userId идентификатор пользователя
     * @return созданный и сохраненный заказ
     */
    @Transactional
    public Order createOrder(Long userId) {
        var user = userService.restFindById(userId);
        var cart = user.getCart();
        var order = new Order();
        var from = cart.getItems();
        var items = order.getItems();

        order.setUser(user);

        if(from.size() == 0) {
            throw new CustomException("Cart size is 0", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        for(var cartItem: from) {
            var orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setUser(user);
            orderItem.setCost(cartItem.getCollection().getCost());
            orderItem.setCollection(cartItem.getCollection());
            orderItem.setQuantity(cartItem.getQuantity());

            items.add(orderItem);
        }

        from.clear();
        cartService.save(cart);

        return save(order);
    }
}

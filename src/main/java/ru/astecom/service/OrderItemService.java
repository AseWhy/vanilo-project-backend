package ru.astecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.OrderItem;
import ru.astecom.repository.OrderItemRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class OrderItemService extends BaseService<OrderItem, Long, OrderItemRepository> {
    @Autowired
    protected OrderService orderService;

    public OrderItemService() {
        super(OrderItem.class);
    }

    public RestPage<OrderItem> listByOrderId(Long orderId, NoodleRestFilter filter) {
        return restList(filter.and(condition -> condition.where("cartId", orderService.restFindById(orderId).getId())));
    }
}

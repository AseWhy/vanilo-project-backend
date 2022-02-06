package ru.astecom.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.DTO.cart_item.CreatorCartItemDTO;
import ru.astecom.DTO.cart_item.MutatorCartItemDTO;
import ru.astecom.models.CartItem;
import ru.astecom.repository.CartItemRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class CartItemService extends BaseService<CartItem, Long, CartItemRepository> {
    @Autowired
    protected CartService cartService;
    @Autowired
    protected CollectionService collectionService;

    public CartItemService() {
        super(CartItem.class);
    }

    /**
     * Получить список товаров в корзине
     *
     * @param cartId идентификатор корзины
     * @param filter фильтер для получения товаров
     * @return страницу с товарами корзины
     */
    public RestPage<CartItem> listByCartId(Long cartId, @NotNull NoodleRestFilter filter) {
        return restList(filter.and(condition -> condition.where("cartId", cartService.restFindById(cartId).getId())));
    }

    /**
     * Добавить элемент в корзину, по идентификатору корзины
     *
     * @param cartId идентификатор корзины
     * @param payload полезная нагрузка для добавления
     * @return элемент корзины
     */
    @Transactional
    public CartItem addByCartId(Long cartId, @NotNull CreatorCartItemDTO payload) {
        var cart = cartService.restFindById(cartId);
        var collection = collectionService.restFindById(payload.getCollectionId());
        var item = new CartItem();

        item.setCartId(cart.getId());
        item.setCart(cart);
        item.setCollection(collection);
        item.setCollectionId(collection.getId());
        item.setUser(cart.getUser());
        item.setUserId(cart.getUserId());

        payload.fill(item);

        cart.getItems().add(item);

        cartService.save(cart);

        return item;
    }

    /**
     * Редактировать элемент корзины по идентификатору
     *
     * @param cartItemId идентификатор элемента корзины
     * @param payload полезная нагрузка для редактирования
     * @return найденный и отредактированный элемент корзины
     */
    public CartItem editById(Long cartItemId, @NotNull MutatorCartItemDTO payload) {
        return save(payload.fill(restFindById(cartItemId)));
    }
}

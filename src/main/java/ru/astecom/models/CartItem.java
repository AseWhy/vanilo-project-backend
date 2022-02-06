package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import ru.astecom.models.base.iIdentifiable;
import ru.astecom.models.base.iUserContains;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cart_items")
public class CartItem implements iIdentifiable<Long>, iUserContains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @ManyToOne
    private Cart cart;

    @Column(name = "cart_id", updatable = false, insertable = false)
    private Long cartId;

    @ManyToOne
    private Collection collection;

    @Column(name = "collection_id", updatable = false, insertable = false)
    private Long collectionId;

    private Long quantity;
}

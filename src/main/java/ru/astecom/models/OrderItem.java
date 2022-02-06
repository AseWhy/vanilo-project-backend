package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import ru.astecom.models.base.iIdentifiable;
import ru.astecom.models.base.iUserContains;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_items")
public class OrderItem implements iIdentifiable<Long>, iUserContains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @ManyToOne
    private Order order;

    @Column(name = "order_id", updatable = false, insertable = false)
    private Long orderId;

    @ManyToOne
    private Collection collection;

    @Column(name = "collection_id", updatable = false, insertable = false)
    private Long collectionId;

    private Long quantity;
    private Double cost;
}

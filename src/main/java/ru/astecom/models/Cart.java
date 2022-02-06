package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import ru.astecom.models.base.iIdentifiable;
import ru.astecom.models.base.iUserContains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart implements iIdentifiable<Long>, iUserContains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.LAZY)
    private User user;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> items = new HashSet<>();
}

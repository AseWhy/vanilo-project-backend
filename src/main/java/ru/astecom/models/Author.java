package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.astecom.models.base.iIdentifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "authors")
public class Author implements iIdentifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import ru.astecom.models.base.iIdentifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "songs")
public class Song implements iIdentifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private Author author;

    @Column(name = "author_id", updatable = false, insertable = false)
    private Long authorId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private Collection collection;

    @Column(name = "collection_id", updatable = false, insertable = false)
    private Long collectionId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private Disk disk;

    @Column(name = "disk_id", updatable = false, insertable = false)
    private Long diskId;

    private String name;
    private Long order;
}

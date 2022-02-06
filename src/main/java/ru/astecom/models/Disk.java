package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import ru.astecom.models.base.iIdentifiable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "disks")
public class Disk implements iIdentifiable<Long> {
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

    @OneToMany(mappedBy = "disk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Song> songs;
}

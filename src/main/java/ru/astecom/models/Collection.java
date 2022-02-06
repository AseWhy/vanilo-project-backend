package ru.astecom.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import ru.astecom.models.base.iIdentifiable;
import ru.astecom.models.support.Lang;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "collections")
public class Collection implements iIdentifiable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Lang lang;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private Author author;

    @Column(name = "author_id", updatable = false, insertable = false)
    private Long authorId;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Song> songs;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Disk> disks;

    @OneToMany(mappedBy = "collection", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Attachment> attachments;

    @Formula("(SELECT COUNT(d.id) FROM disks d WHERE d.collection_id = id)")
    private Long numberOfRecords;

    @Formula("(SELECT COUNT(s.id) FROM songs s WHERE s.collection_id = id)")
    private Long sizeOfRecords;

    private boolean availability;

    private String name;
    private String poster;
    private String label;
    private String condition;
    private String description;
    private Double cost;
    private String eanupc;
}

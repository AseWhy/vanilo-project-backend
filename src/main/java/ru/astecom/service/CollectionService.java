package ru.astecom.service;

import org.springframework.stereotype.Repository;
import ru.astecom.models.Collection;
import ru.astecom.repository.CollectionRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class CollectionService extends BaseService<Collection, Long, CollectionRepository> {
    public CollectionService() {
        super(Collection.class);
    }
}

package ru.astecom.service;

import org.springframework.stereotype.Repository;
import ru.astecom.models.Author;
import ru.astecom.repository.AuthorRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class AuthorService extends BaseService<Author, Long, AuthorRepository> {
    public AuthorService() {
        super(Author.class);
    }
}

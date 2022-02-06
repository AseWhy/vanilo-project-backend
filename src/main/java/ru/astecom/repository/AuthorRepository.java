package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Author;
import ru.astecom.models.Cart;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

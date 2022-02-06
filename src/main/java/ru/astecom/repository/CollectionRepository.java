package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

}

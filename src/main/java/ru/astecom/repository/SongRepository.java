package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Song;
import ru.astecom.models.User;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}

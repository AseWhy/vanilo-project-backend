package ru.astecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astecom.models.Disk;
import ru.astecom.models.Song;

@Repository
public interface DiskRepository extends JpaRepository<Disk, Long> {
}

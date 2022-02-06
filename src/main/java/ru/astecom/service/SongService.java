package ru.astecom.service;

import org.springframework.stereotype.Repository;
import ru.astecom.models.Song;
import ru.astecom.repository.SongRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class SongService extends BaseService<Song, Long, SongRepository> {
    public SongService() {
        super(Song.class);
    }
}

package ru.astecom.service;

import org.springframework.stereotype.Repository;
import ru.astecom.models.Disk;
import ru.astecom.repository.DiskRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class DiskService extends BaseService<Disk, Long, DiskRepository> {
    public DiskService() {
        super(Disk.class);
    }
}

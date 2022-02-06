package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.Disk;
import ru.astecom.service.DiskService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/disks")
@PreAuthorize("isAuthenticated()")
public class DiskController {
    @Autowired
    protected DiskService diskService;

    @GetMapping("/{diskId}")
    public Disk restFindById(@PathVariable("diskId") @Valid Long diskId) {
        return diskService.restFindById(diskId);
    }

    @PostMapping
    public RestPage<Disk> listDisks(@NoodleFilter @Valid NoodleRestFilter filter) {
        return diskService.restList(filter);
    }
}

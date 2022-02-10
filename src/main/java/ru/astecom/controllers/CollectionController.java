package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.Collection;
import ru.astecom.service.CollectionService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/collections")
public class CollectionController {
    @Autowired
    protected CollectionService collectionService;

    @GetMapping("/{collectionId}")
    public Collection restFindById(@PathVariable("collectionId") @Valid Long collectionId) {
        return collectionService.restFindById(collectionId);
    }

    @PostMapping
    public RestPage<Collection> listCollections(@NoodleFilter @Valid NoodleRestFilter filter) {
        return collectionService.restList(filter);
    }
}

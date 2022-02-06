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
import ru.astecom.models.Author;
import ru.astecom.service.AuthorService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    protected AuthorService authorService;

    @GetMapping("/{authorId}")
    public Author restFindById(@PathVariable("authorId") @Valid Long authorId) {
        return authorService.restFindById(authorId);
    }

    @PostMapping
    public RestPage<Author> listAuthors(@NoodleFilter @Valid NoodleRestFilter filter) {
        return authorService.restList(filter);
    }
}

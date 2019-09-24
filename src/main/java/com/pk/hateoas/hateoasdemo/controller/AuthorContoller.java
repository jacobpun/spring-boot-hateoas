package com.pk.hateoas.hateoasdemo.controller;

import com.pk.hateoas.hateoasdemo.model.Author;
import com.pk.hateoas.hateoasdemo.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthorContoller
 */
@RestController
@RequestMapping(path = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorContoller {

    @Autowired private AuthorService authorService;

    @GetMapping("{id}")
    public Author getById(@PathVariable Long id) {
        return this.authorService.getById(id);
    }
}
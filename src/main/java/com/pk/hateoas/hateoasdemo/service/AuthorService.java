package com.pk.hateoas.hateoasdemo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.pk.hateoas.hateoasdemo.model.Author;

import org.springframework.stereotype.Service;

/**
 * In Memory AuthorService
 */
@Service
public class AuthorService {
    private List<Author> authors = Arrays.asList(
        new Author(1, "Author 1"),
        new Author(2, "Author 2"),
        new Author(3, "Author 3"),
        new Author(4, "Author 4")
    );

    public Iterable<Author> getAll() {
        return Collections.unmodifiableList(authors);
    }

    public Author getById(long id) {
        return authors
                    .stream()
                    .filter(auth -> auth.getId() == id)
                    .findFirst()
                    .orElseThrow();
    }
}
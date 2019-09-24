package com.pk.hateoas.hateoasdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.pk.hateoas.hateoasdemo.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.hateoas.hateoasdemo.service.AuthorService;

/**
 * Simple In Memory BookService
 */
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    @Autowired
    public BookService(AuthorService authorService) {
        this.books = Arrays.asList(new Book(1, "Book 1", authorService.getAll()));
    }

    public List<Book> getAll() {
        return Collections.unmodifiableList(books);
    }

    public Book getById(long id) {
        return this.getAll().stream().filter(book -> book.getId() == id).findFirst().orElseThrow();
    }
}
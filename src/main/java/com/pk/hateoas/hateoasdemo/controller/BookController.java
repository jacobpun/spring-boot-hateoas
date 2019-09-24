package com.pk.hateoas.hateoasdemo.controller;

import java.util.List;

import com.pk.hateoas.hateoasdemo.model.Book;
import com.pk.hateoas.hateoasdemo.resource.BookResource;
import com.pk.hateoas.hateoasdemo.resource.assembler.BookResourceAssembler;
import com.pk.hateoas.hateoasdemo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;;

/**
 * BookController
 */
@RestController
@RequestMapping(path = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping(path = "with-links")
    public Resources<BookResource> getAllWithLinks() {
        List<Book> allBooks = this.getAll();
        List<BookResource> bookResources = new BookResourceAssembler().toResources(allBooks);
        Resources<BookResource> allBookResources = new Resources<>(bookResources);
        allBookResources.add(linkTo(methodOn(BookController.class).getAll()).withRel("allBooks"));
        return allBookResources;
    }

    @GetMapping(path = "{id}")
    public Book getById(@PathVariable long id) {
        return this.bookService.getById(id);
    }

    @GetMapping(path = "{id}/with-links")
    public BookResource getByIdWithLinks(@PathVariable long id) {
        Book book = this.bookService.getById(id);
        return new BookResourceAssembler().toResource(book);
    }
}
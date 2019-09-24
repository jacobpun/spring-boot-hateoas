package com.pk.hateoas.hateoasdemo.resource;

import java.util.List;

import com.pk.hateoas.hateoasdemo.model.Book;
import com.pk.hateoas.hateoasdemo.resource.assembler.AuthorResourceAssembler;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;

/**
 * BookResource
 */
public class BookResource extends ResourceSupport{
    @Getter private final String name;
    @Getter private final List<AuthorResource> authors;
    public BookResource(Book book) {
        this.name = book.getName();
        this.authors = new AuthorResourceAssembler().toResources(book.getAuthors());
    }
}
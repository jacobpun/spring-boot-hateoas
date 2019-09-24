package com.pk.hateoas.hateoasdemo.resource.assembler;

import com.pk.hateoas.hateoasdemo.controller.BookController;
import com.pk.hateoas.hateoasdemo.model.Book;
import com.pk.hateoas.hateoasdemo.resource.BookResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * BookResourceAssembler
 */
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

    public BookResourceAssembler() {
        super(BookController.class, BookResource.class);
    }

    @Override
    protected BookResource instantiateResource(Book book) {
        return new BookResource(book);
    }

    @Override
    public BookResource toResource(Book entity) {
        BookResource resource = this.createResourceWithId(entity.getId(), entity);
        return resource;
    }
}
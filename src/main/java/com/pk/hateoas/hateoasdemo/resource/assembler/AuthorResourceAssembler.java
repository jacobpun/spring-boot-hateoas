package com.pk.hateoas.hateoasdemo.resource.assembler;

import com.pk.hateoas.hateoasdemo.controller.AuthorContoller;
import com.pk.hateoas.hateoasdemo.model.Author;
import com.pk.hateoas.hateoasdemo.resource.AuthorResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * AuthorResourceAssembler
 */
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource> {

    public AuthorResourceAssembler() {
        super(AuthorContoller.class, AuthorResource.class);
    }

    @Override
    public AuthorResource toResource(Author entity) {
        return this.createResourceWithId(entity.getId(), entity);
    }

    @Override
    public AuthorResource instantiateResource(Author author) {
        return new AuthorResource(author);
    }
}
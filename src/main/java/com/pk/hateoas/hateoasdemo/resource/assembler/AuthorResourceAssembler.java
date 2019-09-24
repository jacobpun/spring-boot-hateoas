package com.pk.hateoas.hateoasdemo.resource.assembler;

import com.pk.hateoas.hateoasdemo.controller.AuthorContoller;
import com.pk.hateoas.hateoasdemo.model.Author;
import com.pk.hateoas.hateoasdemo.resource.AuthorResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * AuthorResourceAssembler
 */
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource> {

    public AuthorResourceAssembler() {
        super(AuthorContoller.class, AuthorResource.class);
    }

    @Override
    public AuthorResource toResource(Author entity) {
        AuthorResource resource = this.createResourceWithId(entity.getId(), entity);
        resource.add(
            linkTo(methodOn(AuthorContoller.class).getByIdWithLinks(entity.getId())
        ).withRel("selfWithLinks"));
        return resource;
    }

    @Override
    public AuthorResource instantiateResource(Author author) {
        return new AuthorResource(author);
    }
}
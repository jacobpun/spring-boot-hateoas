package com.pk.hateoas.hateoasdemo.resource;

import com.pk.hateoas.hateoasdemo.model.Author;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;

/**
 * AuthorResource
 */
public class AuthorResource extends ResourceSupport {
    @Getter String name;
    public AuthorResource(Author author) {
        this.name = author.getName();
    }
}
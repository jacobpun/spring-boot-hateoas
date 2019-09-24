package com.pk.hateoas.hateoasdemo.resource;

import com.pk.hateoas.hateoasdemo.model.Author;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import lombok.Getter;

/**
 * AuthorResource
 */
@Relation(value = "author", collectionRelation = "authors")
public class AuthorResource extends ResourceSupport {
    @Getter String name;
    public AuthorResource(Author author) {
        this.name = author.getName();
    }
}
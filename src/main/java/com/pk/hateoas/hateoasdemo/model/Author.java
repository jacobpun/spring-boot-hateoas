package com.pk.hateoas.hateoasdemo.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Author
 */
@RequiredArgsConstructor
public class Author {
    @NotNull @Getter final long id;
    @NotNull @Getter final private String name;
}
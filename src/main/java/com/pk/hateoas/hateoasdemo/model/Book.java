package com.pk.hateoas.hateoasdemo.model;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Book {
    @NotNull @Getter final private long id;
    @NotNull @Getter final private String name;
    @NotNull @Getter final private Iterable<Author> authors;
}
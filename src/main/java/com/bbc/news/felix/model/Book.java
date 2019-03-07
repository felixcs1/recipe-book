package com.bbc.news.felix.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Getter;

@Builder
@Getter
public class Book {

    int id;
    String title;
    String author;
    public @Singular List<Recipe> recipes;
}

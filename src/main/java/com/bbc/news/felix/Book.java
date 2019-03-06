package com.bbc.news.felix;

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
    @Singular List<Recipe> recipes;
}

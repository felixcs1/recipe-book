package com.bbc.news.felix;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Builder;
import lombok.Singular;

@Builder
public @Data class Book {

    int id;
    String title;
    String author;
    @Singular List<Recipe> recipes;

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
}

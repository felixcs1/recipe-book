package com.bbc.news.felix;

import java.util.ArrayList;
import java.util.List;

public class Book {

    int id;
    String title;
    String author;
    List<Recipe> recipes;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
        recipes = new ArrayList();
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}

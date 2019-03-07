package com.bbc.news.felix.controller;

import com.bbc.news.felix.model.Recipe;

import java.util.ArrayList;

public interface RecipeControllerInterface {

    public ArrayList<Recipe> getAllRecipes();

    public Recipe getRecipeById(int id);

    public Recipe addRecipe(Recipe recipe);

    public Recipe changeRecipe(int id, Recipe recipe);

    public boolean deleteRecipe(int id);
}

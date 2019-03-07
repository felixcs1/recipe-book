package com.bbc.news.felix.controller;

import com.bbc.news.felix.RecipeGenerator;
import com.bbc.news.felix.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeController {

    HashMap<Integer, Recipe> recipes;

    public RecipeController() {
        RecipeGenerator recipeGenerator = new RecipeGenerator();
        recipes = recipeGenerator.generate();
    }

    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<Recipe>(this.recipes.values());
    }

    public Recipe getRecipeById(int id) {
        return this.recipes.get(id);
    }

    public void addRecipe(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    public void changeRecipe(int id, Recipe recipe) {
        recipes.put(id, recipe);
    }

    public void deleteRecipe(int id) {
        recipes.remove(id);
    }
}

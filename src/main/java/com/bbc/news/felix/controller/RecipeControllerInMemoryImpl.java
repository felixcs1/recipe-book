package com.bbc.news.felix.controller;

import com.bbc.news.felix.RecipeGenerator;
import com.bbc.news.felix.model.Recipe;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class RecipeControllerInMemoryImpl implements RecipeControllerInterface {

    HashMap<Integer, Recipe> recipes;

    int currentID;

    public RecipeControllerInMemoryImpl() {
        RecipeGenerator recipeGenerator = new RecipeGenerator();
        recipes = recipeGenerator.generate();
        currentID = recipes.size() + 1;
    }

    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<Recipe>(this.recipes.values());
    }

    public Recipe getRecipeById(int id) {
        return this.recipes.get(id);
    }

    public Recipe addRecipe(Recipe recipe) {
        if (recipe == null) {
            return null;
        }
        Recipe newRecipe = recipe.toBuilder().id(currentID).build();
        recipes.put(currentID, newRecipe);
        currentID++;
        return newRecipe;
    }

    public Recipe updateRecipe(int id, Recipe recipe) {
        if (recipes.get(id) == null) {
            return null;
        }
        Recipe newRecipe = recipe.toBuilder().id(id).build();
        recipes.put(id, newRecipe);
        return newRecipe;
    }

    public boolean deleteRecipe(int id) {
        if (recipes.get(id) == null) {
            return false;
        }
        recipes.remove(id);
        return true;
    }
}

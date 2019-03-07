package com.bbc.news.felix;

import com.bbc.news.felix.model.Book;
import com.bbc.news.felix.model.Food;
import com.bbc.news.felix.model.Recipe;

import java.util.HashMap;

public class RecipeGenerator {

    public HashMap generate() {

        HashMap<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();

        Food potato = Food.builder().id(1).name("potato").isLiquid(false).units("g").quantity(500).build();
        Food oil = Food.builder().id(2).name("olive oil").isLiquid(true).units("ml").quantity(400).build();
        Food salt = Food.builder().id(3).name("Salt").isLiquid(false).units("pinch").quantity(1).build();

        Recipe chipsRecipe = Recipe.builder().id(1).description("Unsalted chips").serves(3).food(potato).food(oil).instruction("Make the chips!!!").build();
        Recipe saltedChipsRecipe = Recipe.builder().id(2).description("Salted chips").serves(3).food(potato).food(oil).food(salt).instruction("Make the chips!!!").build();

        // Book book1 = Book.builder().id(1).author("Felix").title("Unsalted foods").recipe(chipsRecipe).build();

        recipes.put(chipsRecipe.getId(), chipsRecipe);
        recipes.put(saltedChipsRecipe.getId(), saltedChipsRecipe);

        return recipes;
    }
}

package com.bbc.news.felix;

public class Main {

    public static void main(String[] args) {

        Food potato = Food.builder()
                .id(1)
                .name("potato")
                .isLiquid(true)
                .units("g")
                .quantity(500)
                .build();

        Food oil = Food.builder()
                .id(2)
                .name("olive oil")
                .isLiquid(true)
                .units("ml")
                .quantity(400)
                .build();

        Recipe pancakesRecipe = Recipe.builder()
                .id(1)
                .description("Unsalted chips")
                .serves(3)
                .food(potato)
                .food(oil)
                .instruction("Make the chips!!!")
                .build();

        Book book1 = Book.builder()
                .id(1)
                .author("Felix")
                .title("Unsalted foods")
                .recipe(pancakesRecipe)
                .build();

        book1.recipes.get(0).displayRecipe();
    }
}

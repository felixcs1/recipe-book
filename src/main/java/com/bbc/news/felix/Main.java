package com.bbc.news.felix;

public class Main {

    public static void main(String[] args) {

        Food potato = new Food(1, "potato", false, "g", 500);
        Food oil = new Food(2, "olive oil", true, "ml", 400);
        Food eggs = new Food(3, "olive oil", true, "number", 2);
        Food flower = new Food(4, "olive oil", true, "g", 100);
        Food milk = new Food(5, "olive oil", true, "ml", 300);

        Recipe chipsRecipe = new Recipe(1, "Unslated chips", 4);
        chipsRecipe.addFood(potato);
        chipsRecipe.addFood(oil);
        chipsRecipe.addInstruction("Make the chips!!!");

        Recipe pancakesRecipe = new Recipe(1, "Pancakes", 4);
        pancakesRecipe.addFood(eggs);
        pancakesRecipe.addFood(flower);
        pancakesRecipe.addFood(milk);
        pancakesRecipe.addInstruction("Make the Pancakes!!!");

        Book book1 = new Book(1, "Felix", "Unsalted foods");
        book1.addRecipe(chipsRecipe);
        book1.addRecipe(pancakesRecipe);


        System.out.println(book1.getRecipes().get(0).getInstructions().get(0));
        System.out.println(book1.getRecipes().get(1).getInstructions().get(0));
    }
}

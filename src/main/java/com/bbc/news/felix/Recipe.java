package com.bbc.news.felix;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    int id;
    List<String> instructions;
    List<Food> foods;
    List<Tool> toolsNeeded;
    String description;
    int serves;

    public Recipe(int id, String description, int serves) {
        this.id = id;
        this.instructions = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.toolsNeeded = new ArrayList<>();
        this.description = description;
        this.serves = serves;
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void addTools(Tool tool) {
        this.toolsNeeded.add(tool);
    }

    public void addFoodToRecipe(Food food) {
        this.foods.add(food);
    }

    public List<Tool> getToolsNeeded() {
        return toolsNeeded;
    }

    public void setToolsNeeded(List<Tool> toolsNeeded) {
        this.toolsNeeded = toolsNeeded;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getServes() {
        return serves;
    }

}

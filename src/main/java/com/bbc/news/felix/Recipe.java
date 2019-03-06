package com.bbc.news.felix;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class Recipe {
    int id;
    @Singular List<String> instructions;
    @Singular List<Food> foods;
    @Singular List<Tool> neededTools;
    String description;
    int serves;

    public void displayRecipe() {
        log.error("HELOOOOOOOO");
        System.out.println("Recipe: " + description);
        System.out.println("Foods: " + foods);
    }
}

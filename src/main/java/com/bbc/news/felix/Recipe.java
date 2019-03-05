package com.bbc.news.felix;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Builder;
import lombok.Singular;

@Builder
public @Data class Recipe {

    int id;
    @Singular List<String> instructions;
    @Singular List<Food> foods;
    @Singular List<Tool> neededTools;
    String description;
    int serves;
}

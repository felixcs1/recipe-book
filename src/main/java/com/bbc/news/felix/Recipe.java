package com.bbc.news.felix;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Builder;
import lombok.Singular;

@Builder
@Getter
public class Recipe {
    int id;
    @Singular List<String> instructions;
    @Singular List<Food> foods;
    @Singular List<Tool> neededTools;
    String description;
    int serves;
}

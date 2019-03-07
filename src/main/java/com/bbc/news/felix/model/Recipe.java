package com.bbc.news.felix.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

@Builder(toBuilder = true)
@Getter
@Slf4j
public class Recipe {
    int id;
    @Singular List<String> instructions;
    @Singular List<Food> foods;
    @Singular List<Tool> neededTools;
    String description;
    int serves;
}

package com.bbc.news.felix.controller;

import com.bbc.news.felix.model.Food;
import com.bbc.news.felix.model.Recipe;
import com.bbc.news.felix.model.Tool;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecipeControllerDBImpl implements RecipeControllerInterface {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String recipe_by_id_query =
            "SELECT recipes.recipe_id, recipes.recipe_name, recipes.description, recipes.serves " +
            "FROM recipes " +
            "WHERE recipes.recipe_id = :id;";

    private String food_by_id_query =
            "SELECT foods.food_name, recipe_foods.quantity, foods.units, foods.isLiquid " +
            "FROM recipes " +
            "INNER JOIN recipe_foods ON recipes.recipe_id=recipe_foods.recipe_id " +
            "INNER JOIN foods ON recipe_foods.food_id=foods.food_id " +
            "WHERE recipes.recipe_id = :id;";

    private String tools_by_id_query =
            "SELECT tools.tool_name " +
            "FROM recipes " +
            "INNER JOIN recipe_tools ON recipes.recipe_id=recipe_tools.recipe_id " +
            "INNER JOIN tools ON recipe_tools.tool_id=tools.tool_id " +
            "WHERE recipes.recipe_id = :id;";

    private String instruction_by_id_query =
            "SELECT instructions.instruction FROM recipes " +
            "INNER JOIN instructions ON " +
            "recipes.recipe_id=instructions.recipe_id " +
            "WHERE recipes.recipe_id = :id;";

    private String delete_recipe_by_id_update = "DELETE FROM recipes WHERE recipe_id = :id";

    public RecipeControllerDBImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Recipe getRecipeById(int id) {
        final MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
        mappedParameters.addValue("id", id);

        // Get foods for given recipe
        List<Food> foods = namedParameterJdbcTemplate.query(food_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Food.builder()
                        .name(rs.getString("food_name"))
                        .quantity(rs.getInt("quantity"))
                        .units(rs.getString("units"))
                        .isLiquid(rs.getBoolean("isLiquid"))
                        .build()
        );

        // Get tools for given recipe
        List<Tool> tools = namedParameterJdbcTemplate.query(tools_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Tool.builder()
                        .name(rs.getString("tool_name"))
                        .build()
        );

        // Get tools for given recipe
        List<String> instructions = namedParameterJdbcTemplate.query(instruction_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> rs.getString("instruction")
        );

        // Get recipes by id
        List<Recipe> recipes = namedParameterJdbcTemplate.query(recipe_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Recipe.builder()
                        .id(rs.getInt("recipe_id"))
                        .recipe_name(rs.getString("recipe_name"))
                        .description(rs.getString("description"))
                        .serves(rs.getInt("serves"))
                        .foods(foods)
                        .neededTools(tools)
                        .instructions(instructions)
                        .build()
        );

        if (recipes.size() != 1) {
            System.out.println("Recipes array length not equal to 1");
            return null;
        }

        return recipes.get(0);
    }

    public ArrayList<Recipe> getAllRecipes() {
        return null;
    }

    public Recipe addRecipe(Recipe recipe) {
       return null;
    }

    public Recipe updateRecipe(int id, Recipe recipe) {
        return null;
    }

    public boolean deleteRecipe(int id) {
        final MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
        mappedParameters.addValue("id", id);

        // Delete recipe
        int completed = namedParameterJdbcTemplate.update(delete_recipe_by_id_update, mappedParameters);
        return completed == 1 ? true : false;
    }

}

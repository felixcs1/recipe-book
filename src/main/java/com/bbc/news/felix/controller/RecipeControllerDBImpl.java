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

    private String all_recipes_query =
            "SELECT recipes.recipe_id, recipes.recipe_name, recipes.description, recipes.serves " +
            "FROM recipes;";

    private String recipe_by_id_query =
            "SELECT recipes.recipe_id, recipes.recipe_name, recipes.description, recipes.serves " +
            "FROM recipes " +
            "WHERE recipes.recipe_id = :id;";

    private String foods_by_id_query =
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

    private String add_recipe_query =
            "INSERT INTO recipes (recipe_name, description, serves) VALUES(:recipe_name, :description, :serves);";

    private String delete_recipe_by_id_update = "DELETE FROM recipes WHERE recipe_id = :id";

    public RecipeControllerDBImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Recipe getRecipeById(int id) {
        final MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
        mappedParameters.addValue("id", id);

        // Get recipes by id
        List<Recipe> recipes = namedParameterJdbcTemplate.query(recipe_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Recipe.builder()
                        .id(rs.getInt("recipe_id"))
                        .recipe_name(rs.getString("recipe_name"))
                        .description(rs.getString("description"))
                        .serves(rs.getInt("serves"))
                        .foods(getFoodsByRecipeId(mappedParameters))
                        .neededTools(getToolsByRecipeId(mappedParameters))
                        .instructions(getInstructionByRecipeId(mappedParameters))
                        .build()
        );

        if (recipes.size() != 1) {
            System.out.println("Recipes array length not equal to 1");
            return null;
        }

        return recipes.get(0);
    }

    public ArrayList<Recipe> getAllRecipes() {

        // Get recipes by id
        List<Recipe> recipes = namedParameterJdbcTemplate.query(all_recipes_query,
                (ResultSet rs, int row) -> {

                        final MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
                        mappedParameters.addValue("id", rs.getInt("recipe_id"));

                        return Recipe.builder()
                        .id(rs.getInt("recipe_id"))
                        .recipe_name(rs.getString("recipe_name"))
                        .description(rs.getString("description"))
                        .serves(rs.getInt("serves"))
                        .foods(getFoodsByRecipeId(mappedParameters))
                        .neededTools(getToolsByRecipeId(mappedParameters))
                        .instructions(getInstructionByRecipeId(mappedParameters))
                        .build();
                }
        );
        return new ArrayList<Recipe>(recipes);
    }

    public Recipe addRecipe(Recipe recipe) {
        final MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
        mappedParameters.addValue("recipe_name", recipe.getRecipe_name());
        mappedParameters.addValue("description", recipe.getDescription());
        mappedParameters.addValue("servers", recipe.getServes());

        int completed = namedParameterJdbcTemplate.update(add_recipe_query, mappedParameters);
        return recipe;
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

    ///////////////---------- Helper Queries ------------//////////////////////////////////
    public List<String> getInstructionByRecipeId(MapSqlParameterSource mappedParameters) {
        return namedParameterJdbcTemplate.query(instruction_by_id_query, mappedParameters,
                (ResultSet instr_rs, int instr_row) -> instr_rs.getString("instruction")
        );
    }

    public List<Food> getFoodsByRecipeId(MapSqlParameterSource mappedParameters) {
        return namedParameterJdbcTemplate.query(foods_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Food.builder()
                        .name(rs.getString("food_name"))
                        .quantity(rs.getInt("quantity"))
                        .units(rs.getString("units"))
                        .isLiquid(rs.getBoolean("isLiquid"))
                        .build()
        );
    }

    public List<Tool> getToolsByRecipeId(MapSqlParameterSource mappedParameters) {
        return namedParameterJdbcTemplate.query(tools_by_id_query, mappedParameters,
                (ResultSet rs, int row) -> Tool.builder()
                        .name(rs.getString("tool_name"))
                        .build()
        );
    }
}

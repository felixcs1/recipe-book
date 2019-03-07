package com.bbc.news.felix;

import com.bbc.news.felix.controller.RecipeController;
import com.bbc.news.felix.model.Book;
import com.bbc.news.felix.model.Food;
import com.bbc.news.felix.model.Recipe;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.ArrayList;


@Component
@Path("/recipes")
public class RecipeEndpoint {

    RecipeController rc = new RecipeController();

    @GET
    @Produces("application/json")
    public ArrayList<Recipe> getAllRecipes() {
        return rc.getAllRecipes();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Recipe getRecipeById(@PathParam("id") int id) {
        return rc.getRecipeById(id);
    }

    @POST
    @Path("/add-recipe")
    @Consumes("application/json")
    @Produces("application/json")
    public Recipe addRecipe(Recipe recipe) {
        rc.addRecipe(recipe);
        return recipe;
    }

    @PUT
    @Path("/change-recipe/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Recipe changeRecipe(@PathParam("id") int id, Recipe recipe) {
        rc.changeRecipe(id, recipe);
        return recipe;
    }

    @DELETE
    @Path("/delete-recipe/{id}")
    @Produces("application/json")
    public Recipe changeRecipe(@PathParam("id") int id) {
        rc.deleteRecipe(id);
        return rc.getRecipeById(id);
    }
}

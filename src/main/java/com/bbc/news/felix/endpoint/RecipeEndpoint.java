package com.bbc.news.felix.endpoint;

import com.bbc.news.felix.controller.RecipeControllerInterface;
import com.bbc.news.felix.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Slf4j
@Component
@Path("/recipes")
@Produces("application/json")
public class RecipeEndpoint {

    private RecipeControllerInterface rc;

    public RecipeEndpoint(RecipeControllerInterface rc) {
        log.info("CREATING endpoint");
        this.rc = rc;
    }

    @GET
    public Response getAllRecipes() {
        ArrayList<Recipe> recipes = rc.getAllRecipes();
        if (recipes == null) {
            return Response.status(404).build();
        }
        return Response.status(200)
                .entity(recipes)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getRecipeById(@PathParam("id") int id) {
        Recipe recipe = rc.getRecipeById(id);
        if (recipe == null) {
            return Response.status(404).build();
        }
        return Response.status(200)
                .entity(recipe)
                .build();
    }

    @POST
    @Consumes("application/json")
    public Response addRecipe(Recipe recipe) {
        Recipe recipeAdded = rc.addRecipe(recipe);
        if (recipeAdded == null) {
            return Response.status(404).build();
        }
        return Response.status(200)
                .entity(recipeAdded)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response changeRecipe(@PathParam("id") int id, Recipe recipe) {
        Recipe updatedRecipe = rc.updateRecipe(id, recipe);
        if (updatedRecipe == null) {
            return Response.status(404).build();
        }
        return Response.status(200)
                .entity(updatedRecipe)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRecipe(@PathParam("id") int id) {
        boolean isDeleted = rc.deleteRecipe(id);
        return Response.status(isDeleted ? 200 : 404).build();
    }
}

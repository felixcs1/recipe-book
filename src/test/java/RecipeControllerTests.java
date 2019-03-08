import com.bbc.news.felix.controller.RecipeControllerInMemoryImpl;
import com.bbc.news.felix.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RecipeControllerTests {

    private RecipeControllerInMemoryImpl rc;

    @Before
    public void setup() {
        rc = new RecipeControllerInMemoryImpl();
    }

    @Test
    public void getAllRecipesShouldReturnAnArrayListOfRecipes() {
        assertThat(rc.getAllRecipes(), instanceOf(ArrayList.class));
        assertThat(rc.getAllRecipes().get(0), instanceOf(Recipe.class));
        assertThat(rc.getAllRecipes().size(), equalTo(rc.getRecipes().size()));
    }

    @Test
    public void getRecipeByNonExistentIdShouldReturnNull() {
        assertThat(rc.getRecipeById(-1), equalTo(null));
    }

    @Test
    public void getRecipeByExistingIdShouldReturnRecipe() {
        assertThat(rc.getRecipeById(1).getId(), equalTo(1));
    }

    @Test
    public void addANullValuedRecipeShouldReturnNull() {
        assertThat(rc.addRecipe(null), equalTo(null));
    }

    @Test
    public void addANewRecipeShouldReturnTheNewRecipe() {
        Recipe chipsRecipe = Recipe.builder().description("Unsalted chips").serves(3).instruction("Make the chips!!!").build();
        assertThat(rc.addRecipe(chipsRecipe).getDescription(), equalTo("Unsalted chips"));
    }

    @Test
    public void updateRecipeWithNonExistentIdShouldReturnNull() {
        Recipe newChipsRecipe = Recipe.builder().description("Unsalted chips - updated").serves(3).instruction("Make the chips!!!").build();
        assertThat(rc.updateRecipe(-1, newChipsRecipe), equalTo(null));
    }

    @Test
    public void updateRecipeWithExistingIdShouldReturnUpdatedRecipe() {
        Recipe newChipsRecipe = Recipe.builder().description("Unsalted chips - updated").serves(3).instruction("Make the chips!!!").build();
        assertThat(rc.updateRecipe(1, newChipsRecipe).getDescription(), equalTo("Unsalted chips - updated"));
    }

    @Test
    public void deleteRecipeWithExistingIdShouldReturnTrue() {
        assertThat(rc.deleteRecipe(1), equalTo(true));
    }

    @Test
    public void deleteRecipeNonExistentIdShouldReturnFalse() {
        assertThat(rc.deleteRecipe(-1), equalTo(false));
    }
}

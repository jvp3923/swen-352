package coffeemaker;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecipeBookTest {

	@Test
	public void testRecipeBook() {
		RecipeBook rb = new RecipeBook();
		
		int numRecipes = rb.getRecipes().length;
		assertEquals(numRecipes, 4);
	}
	
	@Test
	public void testAddRecipe() {
		RecipeBook rb = new RecipeBook();
		Recipe[] recipes;
		
		Recipe recipe = new Recipe();
		
		rb.addRecipe(recipe);
		recipes = rb.getRecipes();
		
		assertEquals(recipes[0], recipe);
		
		rb.addRecipe(recipe);
		recipes = rb.getRecipes();
		
		assertEquals(recipes[0], recipe);
		assertEquals(recipes[1], null);
	}
	
	@Test
	public void testEditRecipe() {
		RecipeBook rb = new RecipeBook();
		Recipe[] recipes;
		
		Recipe recipeOne = new Recipe();
		recipeOne.setName("Recipe 1");
		

		Recipe recipeTwo = new Recipe();
		recipeTwo.setName("Recipe 2");
		
		rb.addRecipe(recipeOne);
		rb.editRecipe(0, recipeTwo);
		recipes = rb.getRecipes();
		
		assertEquals(recipes[0], recipeTwo);
		
		String result = rb.editRecipe(1, recipeOne);
		assertEquals(result, null);
	}
	
	@Test
	public void testDeleteRecipe() {
		RecipeBook rb = new RecipeBook();
		Recipe[] recipes;
		String result;
		
		Recipe recipe = new Recipe();
		recipe.setName("delete me");
		rb.addRecipe(recipe);
		
		result = rb.deleteRecipe(0);
		assertEquals(result, "delete me");
		
		result = rb.deleteRecipe(1);
		assertEquals(result, null);
	}

}

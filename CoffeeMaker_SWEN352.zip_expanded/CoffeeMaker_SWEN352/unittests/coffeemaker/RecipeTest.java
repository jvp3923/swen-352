package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.RecipeException;

class RecipeTest {

	@Test
	void testGetAmtChocolate() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtChocolate(), 0);
	}
	
	@Test
	void testSetAmtChocolate() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("5");
		assertEquals(recipe.getAmtChocolate(), 5);
	}
	
	@Test
	void testSetAmtChocolateNegative() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("-5");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
		}
	}
	
	@Test
	void testSetAmtChocolateNonInteger() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("number");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
		}
	}
	
	@Test
	void testGetAmtCoffee() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtCoffee(), 0);
	}
	
	@Test
	void testSetAmtCoffee() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("5");
		assertEquals(recipe.getAmtCoffee(), 5);
	}
	
	@Test
	void testSetAmtCoffeeNegative() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtCoffee("-5");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
		}
	}
	
	@Test
	void testSetAmtCoffeeNonInteger() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtCoffee("number");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
		}
	}
	
	@Test
	void testGetAmtMilk() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtMilk(), 0);
	}
	
	@Test
	void testSetAmtMilk() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("5");
		assertEquals(recipe.getAmtMilk(), 5);
	}
	
	@Test
	void testSetAmtMilkNegative() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtMilk("-5");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of milk must be a positive integer");
		}
	}
	
	@Test
	void testSetAmtMilkNonInteger() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtMilk("number");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of milk must be a positive integer");
		}
	}
	
	@Test
	void testSetAmtMilkFloat() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtMilk("5.0");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of milk must be a positive integer");
		}
	}
	
	@Test
	void testGetAmtSugar() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtSugar(), 0);
	}
	
	@Test
	void testSetAmtSugar() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("5");
		assertEquals(recipe.getAmtSugar(), 5);
	}
	
	@Test
	void testSetAmtSugarNegative() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtSugar("-5");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
		}
	}
	
	@Test
	void testSetAmtSugarNonInteger() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtSugar("number");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
		}
	}
	
	@Test
	void testGetName() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getName(), "");
	}
	
	@Test
	void testSetNameNull() {
		Recipe recipe = new Recipe();
		recipe.setName(null);
		assertEquals(recipe.getName(), "");
	}
	
	@Test
	void testSetNameNew() {
		Recipe recipe = new Recipe();
		recipe.setName("Dylan");
		assertEquals(recipe.getName(), "Dylan");
	}
	
	@Test
	void testGetPrice() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getPrice(), 0);
	}
	
	@Test
	void testSetPrice() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setPrice("5");
		assertEquals(recipe.getPrice(), 5);
	}
	
	@Test
	void testSetPriceNegative() {
		Recipe recipe = new Recipe();
		try {
			recipe.setPrice("-5");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	void testSetPriceString() {
		Recipe recipe = new Recipe();
		try {
			recipe.setPrice("number");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	void testSetPriceBoolean() {
		Recipe recipe = new Recipe();
		try {
			recipe.setPrice("true");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	void testSetPricefloat() {
		Recipe recipe = new Recipe();
		try {
			recipe.setPrice("5.0");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	void testSetPriceNegativeFloat() {
		Recipe recipe = new Recipe();
		try {
			recipe.setPrice("-5.0");
		} catch (RecipeException e) {
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	void testToString() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.toString(), "");
	}
	
	@Test
	void testHashCode() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.hashCode(), 31);
	}
	
	@Test
	void testEquals() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.equals(recipe), true);
	}
	
	@Test
	void testEqualsNull() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.equals(null), false);
	}
	
	@Test
	void testEqualsClass() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.equals(1), false);
	}
	
	@Test
	void testEqualsNameNull() {
		Recipe recipe = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe2.setName("Dylan");
		assertEquals(recipe.equals(recipe2), false);
	}
	
	@Test
	void testEqualsNameDifferent() {
		Recipe recipe = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe.setName("Mike");
		recipe2.setName("Dylan");
		assertEquals(recipe.equals(recipe2), false);
	}
	
	@Test
	void testEqualsNameIdentical() {
		Recipe recipe = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe.setName("Dylan");
		recipe2.setName("Dylan");
		assertEquals(recipe.equals(recipe2), true);
	}
}

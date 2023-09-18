package coffeemaker;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coffeemaker.exceptions.InventoryException;
import coffeemaker.exceptions.RecipeException;

public class InventoryTest {

    Inventory tInventory;
    Recipe recipe;

    @Before
    public void setUp() {
        tInventory = new Inventory();
        recipe = new Recipe();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        assertNotEquals("", tInventory.toString());
    }

    @Test
    public void testSettingNegativeChocolate() {
        int addedChocolate = tInventory.getChocolate();

        tInventory.setChocolate(-1);

        assertEquals(addedChocolate, tInventory.getChocolate());
    }

    @Test
    public void testSettingNegativeChocolate2() {
        int addedChocolate = tInventory.getChocolate();

        tInventory.setChocolate(-1000);

        assertEquals(addedChocolate, tInventory.getChocolate());
    }

    @Test
    public void testSettingZeroChocolate() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate, tInventory.getChocolate());
        addedChocolate = 0;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate, tInventory.getChocolate());
    }

    @Test
    public void testSettingPositiveChocolate() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate, tInventory.getChocolate());

    }

    @Test
    public void testSettingPositiveChocolate2() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate, tInventory.getChocolate());

    }

    @Test
    public void testAddingInvalidChocolate() {

        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addChocolate("-100");
        });
    }

    @Test
    public void testAddingInvalidChocolate2() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addChocolate("0.0");
        });
    }

    @Test
    public void testAddingValidChocolate() {
        int nChocolate = tInventory.getChocolate();
        assertDoesNotThrow(() -> {
            tInventory.addChocolate("0");
        });

        assertEquals(nChocolate, tInventory.getChocolate());
    }

    @Test
    public void testAddingValidChocolate2() {
        int nChocolate = tInventory.getChocolate();
        assertDoesNotThrow(() -> {
            tInventory.addChocolate("10");
        });

        assertEquals(nChocolate + 10, tInventory.getChocolate());
    }

    @Test
    public void testAddingNonIntegerInvalid() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addChocolate("10.5");
        });

    }

    @Test
    public void testAddingNegativeNonIntegerInvalid() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addChocolate("-10.5");
        });

    }

    @Test
    public void testGetChocolocate() {
        int expectedChocolate = 10;
        tInventory.setChocolate(expectedChocolate);
        assertEquals(expectedChocolate, tInventory.getChocolate());
    }

    @Test
    public void testSettingNegativeCoffee() {
        int addedCoffee = tInventory.getCoffee();

        tInventory.setCoffee(-1);

        assertEquals(addedCoffee, tInventory.getCoffee());
    }

    @Test
    public void testSettingNegativeCoffee2() {
        int addedCoffee = tInventory.getCoffee();

        tInventory.setCoffee(-1000);

        assertEquals(addedCoffee, tInventory.getCoffee());
    }

    @Test
    public void testSettingZeroCoffee() {
        int addedCoffee = 20;
        tInventory.setCoffee(addedCoffee);
        assertEquals(addedCoffee, tInventory.getCoffee());
        addedCoffee = 0;
        tInventory.setCoffee(addedCoffee);
        assertEquals(addedCoffee, tInventory.getCoffee());
    }

    @Test
    public void testSettingPositiveCoffee() {
        int addedCoffee = 20;
        tInventory.setCoffee(addedCoffee);
        assertEquals(addedCoffee, tInventory.getCoffee());

    }

    @Test
    public void testSettingPositiveCoffee2() {
        int addedCoffee = 1;
        tInventory.setCoffee(addedCoffee);
        assertEquals(addedCoffee, tInventory.getCoffee());

    }

    @Test
    public void testAddingInvalidCoffee() {

        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addCoffee("-100");
        });
    }

    @Test
    public void testAddingInvalidCoffee2() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addCoffee("0.0");
        });
    }

    @Test
    public void testAddingValidCoffee() {
        int nCoffe = tInventory.getCoffee();
        assertDoesNotThrow(() -> {
            tInventory.addCoffee("0");
        });

        assertEquals(nCoffe, tInventory.getCoffee());
    }

    @Test
    public void testAddingValiCoffee() {
        int nCoffe = tInventory.getCoffee();
        assertDoesNotThrow(() -> {
            tInventory.addCoffee("10");
        });

        assertEquals(nCoffe + 10, tInventory.getCoffee());
    }

    @Test
    public void testAddingNonIntegerInvalidCoffee() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addCoffee("10.5");
        });

    }

    @Test
    public void testAddingNegativeNonIntegerInvalidCoffee() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addCoffee("-10.5");
        });

    }

    @Test
    public void testGetCoffee() {
        int expectedCoffee = 10;
        tInventory.setChocolate(expectedCoffee);
        assertEquals(expectedCoffee, tInventory.getChocolate());
    }

    @Test
    public void testSettingNegativeMilk() {
        int addedMilk = tInventory.getMilk();

        tInventory.setMilk(-1);

        assertEquals(addedMilk, tInventory.getMilk());
    }

    @Test
    public void testSettingNegativeMilk2() {
        int addedMilk = tInventory.getMilk();

        tInventory.setMilk(-1000);

        assertEquals(addedMilk, tInventory.getMilk());
    }

    @Test
    public void testSettingZeroMilk() {
        int addedMilk = 20;
        tInventory.setMilk(addedMilk);
        assertEquals(addedMilk, tInventory.getMilk());
        addedMilk = 0;
        tInventory.setMilk(addedMilk);
        assertEquals(addedMilk, tInventory.getMilk());
    }

    @Test
    public void testSettingPositiveMilk() {
        int addedMilk = 20;
        tInventory.setMilk(addedMilk);
        assertEquals(addedMilk, tInventory.getMilk());

    }

    @Test
    public void testSettingPositiveMilk2() {
        int addedMilk = 1;
        tInventory.setMilk(addedMilk);
        assertEquals(addedMilk, tInventory.getMilk());

    }

    @Test
    public void testAddingInvalidMilk() {

        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addMilk("-100");
        });
    }

    @Test
    public void testAddingInvalidMilk2() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addMilk("0.0");
        });
    }

    @Test
    public void testAddingValidMilk() {
        int nCoffe = tInventory.getMilk();
        assertDoesNotThrow(() -> {
            tInventory.addMilk("0");
        });

        assertEquals(nCoffe, tInventory.getMilk());
    }

    @Test
    public void testAddingValidMilk2() {
        int nCoffe = tInventory.getMilk();
        assertDoesNotThrow(() -> {
            tInventory.addMilk("10");
        });

        assertEquals(nCoffe + 10, tInventory.getMilk());
    }

    @Test
    public void testAddingNonIntegerInvalidMilk() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addMilk("10.5");
        });

    }

    @Test
    public void testAddingNegativeNonIntegerInvalidMilk() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addMilk("-10.5");
        });

    }

    @Test
    public void testGetMilk() {
        int expectedMilk = 10;
        tInventory.setMilk(expectedMilk);

        assertEquals(expectedMilk, tInventory.getMilk());
    }

    @Test
    public void testSettingNegativeSugar() {
        int addedSugar = tInventory.getSugar();

        tInventory.setSugar(-1);

        assertEquals(addedSugar, tInventory.getSugar());
    }

    @Test
    public void testSettingNegativeSugar2() {
        int addedSugar = tInventory.getSugar();

        tInventory.setSugar(-1000);

        assertEquals(addedSugar, tInventory.getSugar());
    }

    @Test
    public void testSettingZeroSugar() {
        int addedSugar = 20;
        tInventory.setSugar(addedSugar);
        assertEquals(addedSugar, tInventory.getSugar());
        addedSugar = 0;
        tInventory.setSugar(addedSugar);
        assertEquals(addedSugar, tInventory.getSugar());
    }

    @Test
    public void testSettingPositiveSugar() {
        int addedSugar = 20;
        tInventory.setSugar(addedSugar);
        assertEquals(addedSugar, tInventory.getSugar());

    }

    @Test
    public void testSettingPositiveSugar2() {
        int addedSugar = 1;
        tInventory.setSugar(addedSugar);
        assertEquals(addedSugar, tInventory.getSugar());

    }

    @Test
    public void testAddingInvalidSugar() {

        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addSugar("-100");
        });
    }

    @Test
    public void testAddingInvalidSugar2() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addSugar("0.0");
        });
    }

    @Test
    public void testAddingValidSugar() {
        int nCoffe = tInventory.getSugar();
        assertDoesNotThrow(() -> {
            tInventory.addSugar("0");
        });

        assertEquals(nCoffe, tInventory.getSugar());
    }

    @Test
    public void testAddingValidSugar2() {
        int nCoffe = tInventory.getSugar();
        assertDoesNotThrow(() -> {
            tInventory.addSugar("10");
        });

        assertEquals(nCoffe + 10, tInventory.getSugar());
    }

    @Test
    public void testAddingNonIntegerInvalidSugar() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addSugar("10.5");
        });

    }

    @Test
    public void testAddingNegativeNonIntegerInvalidSugar() {
        assertThrowsExactly(InventoryException.class, () -> {
            tInventory.addSugar("-10.5");
        });

    }

    @Test
    public void testGetSugar() {
        int expectedSugar = 10;
        tInventory.setSugar(expectedSugar);

        assertEquals(expectedSugar, tInventory.getSugar());
    }

    @Test
    public void testUseIngredients() {
        try {
            recipe.setAmtChocolate("10");
            recipe.setAmtCoffee("10");
            recipe.setAmtMilk("10");
            recipe.setAmtSugar("10");

        } catch (RecipeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertTrue(tInventory.enoughIngredients(recipe));

    }

    @Test
    public void testUseIngredientsWithInsufficientAmount() {
        try {
            recipe.setAmtChocolate("20");
            recipe.setAmtCoffee("20");
            recipe.setAmtMilk("20");
            recipe.setAmtSugar("20");

        } catch (RecipeException e) {
            e.printStackTrace();
        }

        assertFalse(tInventory.useIngredients(recipe));

    }

    @Test
    public void testInventoryAfterIngredientsUsage() {

        String recipeAmountStr = "10";
        int recipeAmount = 10;
        int inventoryAmount = recipeAmount * 2;
        try {

            tInventory.setChocolate(inventoryAmount);
            tInventory.setMilk(inventoryAmount);
            tInventory.setSugar(inventoryAmount);
            tInventory.setCoffee(inventoryAmount);

            recipe.setAmtChocolate(recipeAmountStr);
            recipe.setAmtCoffee(recipeAmountStr);
            recipe.setAmtMilk(recipeAmountStr);
            recipe.setAmtSugar(recipeAmountStr);
        } catch (RecipeException e) {
            e.printStackTrace();
        }

        assertTrue(tInventory.useIngredients(recipe));
        assertEquals(inventoryAmount - recipeAmount, tInventory.getChocolate());
        assertEquals(inventoryAmount - recipeAmount, tInventory.getCoffee());
        assertEquals(inventoryAmount - recipeAmount, tInventory.getMilk());
        assertEquals(inventoryAmount - recipeAmount, tInventory.getSugar());

    }

}

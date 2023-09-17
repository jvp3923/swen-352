package coffeemaker;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coffeemaker.exceptions.InventoryException;

public class InventoryTest {

    Inventory tInventory;

    @Before
    public void setUp() {
        tInventory = new Inventory();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSettingNegativeChocolate() {
        int addedChocolate = tInventory.getChocolate();

        tInventory.setChocolate(-1);

        assertEquals(addedChocolate,tInventory.getChocolate());
    }

    @Test
    public void testSettingNegativeChocolate2() {
        int addedChocolate = tInventory.getChocolate();

        tInventory.setChocolate(-1000);

        assertEquals(addedChocolate,tInventory.getChocolate());
    }

    @Test
    public void testSettingZeroChocolate() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate,tInventory.getChocolate());
        addedChocolate = 0;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate,tInventory.getChocolate());
    }

    @Test
    public void testSettingPositiveChocolate() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate,tInventory.getChocolate());

    }

    @Test
    public void testSettingPositiveChocolate2() {
        int addedChocolate = 20;
        tInventory.setChocolate(addedChocolate);
        assertEquals(addedChocolate,tInventory.getChocolate());

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

        assertEquals(nChocolate,tInventory.getChocolate());
    }

    @Test
    public void testAddingValidChocolate2() {
        int nChocolate = tInventory.getChocolate();
        assertDoesNotThrow(() -> {
            tInventory.addChocolate("10");
        });

        assertEquals(nChocolate + 10,tInventory.getChocolate());
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


}

package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppetizerTest {
  Appetizer mixedFruit;
  Appetizer mixedFruitDuplicate;
  Appetizer sideSalad;
  Appetizer hotWings;
  Appetizer mozzSticks;
  Appetizer samplerPlate;

  Appetizer samplerPlateCheaper;
  String expectedOutputHotWings;

  @BeforeEach
  public void setUp() {
    mixedFruit = new Appetizer("Mixed Fruit", 215);
    mixedFruitDuplicate = new Appetizer("Mixed Fruit", 215);
    sideSalad = new Appetizer("Side Salad", 335);
    hotWings = new Appetizer("Hot Wings", 355);
    mozzSticks = new Appetizer("Mozzarella Sticks", 420);
    samplerPlate = new Appetizer("Sampler Plate", 580);
    samplerPlateCheaper = new Appetizer("Sampler Plate", 350);

  }

  @Test
  public void equalsTest() {
    assertTrue(mixedFruit.equals(mixedFruitDuplicate));
    assertTrue(mixedFruit.equals(mixedFruit));
    assertFalse(mixedFruit.equals(sideSalad));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(mixedFruit.hashCode(), mixedFruitDuplicate.hashCode());
    assertEquals(mixedFruit.hashCode(), mixedFruit.hashCode());
    assertFalse(sideSalad.hashCode() == mixedFruit.hashCode());
    assertFalse(mixedFruit.hashCode() == samplerPlate.hashCode());
  }

  @Test
  public void toStringTest() {
    expectedOutputHotWings = "Hot Wings ($3.55)";
    assertEquals(expectedOutputHotWings, hotWings.toString());
  }

  @Test
  public void compareToTest() {
    assertEquals(-1, mixedFruit.compareTo(sideSalad));
    assertEquals(0, mixedFruit.compareTo(mixedFruitDuplicate));
    assertEquals(1, samplerPlate.compareTo(samplerPlateCheaper));
  }

}

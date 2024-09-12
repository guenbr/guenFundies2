package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WaltzGeneratorTest {
    WaltzGenerator generator;

    private static final long seed = 123456L;

    @BeforeEach
    public void setUp() {
        generator = new WaltzGenerator(seed);
    }

    @Test
    public void rollDiceTestDieValid() {
        for (int i = 1; i < 6; i++) {
            int num = generator.rollDice(i);
            assertTrue(num >= i && num <= 6 * i);
        }
    }

    @Test
    public void rollDiceTestTwoDiceValid() {
        for (int i = 6; i < 12; i++) {
            int num = generator.rollDice(i);
            assertTrue(num >= i && num <= 6 * i);
        }
    }

    @Test
    public void rollDiceTestInvalid() {
        assertThrows(IllegalArgumentException.class, () -> generator.rollDice(0));
        assertThrows(IllegalArgumentException.class, () -> generator.rollDice(-2));
    }

    @Test
    public void buildTableListStringSingleDieTest() throws IOException {
        List<String> lines = List.of("1", "2", "3", "4", "5", "6", "7");
        String[][] table = generator.buildTable(lines);
        assertEquals(0, table[0].length);
        assertEquals(7, table.length);
    }

    @Test
    public void buildTableListStringTwoDiceTest() {
        List<String> lines = List.of("1", "1A, 1B", "2A, 2B", "3A, 3B", "4A, 4B", "5A, 5B", "6A, 6B, 6C, 6D");
        String[][] table = generator.buildTable(lines);
        assertEquals(0, table[0].length);
        assertEquals(7, table.length);
    }

}

package islands.model.student;

import islands.model.TileColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelImplementationTest {
    GameModelImplementation graph;
    GameModelImplementation graphAllWhite;
    GameModelImplementation graphSomeBlack;
    GameModelImplementation graphTwoByTwo;
    GameModelImplementation graphWhiteOver;
    GameModelImplementation graphBlackOver;

    @BeforeEach
    public void setUp() {
        graph = new GameModelImplementation(2);
    }

    @Test
    public void canPlayTest() {
        assertTrue(graph.canPlay(0, 0));
        assertTrue(graph.canPlay(1, 1));
        assertThrows(IllegalArgumentException.class, () -> graph.canPlay(2, 1));
        assertThrows(IllegalArgumentException.class, () -> graph.canPlay(1, 2));
        assertThrows(IllegalArgumentException.class, () -> graph.canPlay(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> graph.canPlay(1, -1));
    }

    @Test
    public void makePlayTest() {
        assertEquals("nn\nnn\n", graph.getBoardString());
        graph.makePlay(0, 0, TileColor.BLACK);
        assertEquals("Bn\nnn\n", graph.getBoardString());
        assertThrows(IllegalArgumentException.class, () -> graph.makePlay(0, 0, TileColor.WHITE));
        graph.makePlay(0, 1, TileColor.WHITE);
        assertEquals("BW\nnn\n", graph.getBoardString());
        assertThrows(IllegalArgumentException.class, () -> graph.makePlay(0, 1, TileColor.BLACK));
        graph.makePlay(1, 0, TileColor.BLACK);
        graph.makePlay(1, 1, TileColor.WHITE);
        assertEquals("BW\nBW\n", graph.getBoardString());
    }

    @Test
    public void getSizeTest() {
        assertEquals(2, graph.getSize());
    }

    @Test
    public void getScoreTest() {
        graphAllWhite = new GameModelImplementation(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graphAllWhite.makePlay(i, j, TileColor.WHITE);
            }
        }
        assertEquals(1, graphAllWhite.getScore(TileColor.WHITE));
        graphSomeBlack = new GameModelImplementation(3);
        // Middle
        graphSomeBlack.makePlay(1, 1, TileColor.BLACK);
        // Bottom
        graphSomeBlack.makePlay(2, 1, TileColor.BLACK);
        // Bottom Right
        graphSomeBlack.makePlay(2, 2, TileColor.BLACK);
        // Right
        graphSomeBlack.makePlay(1, 2, TileColor.BLACK);
        /*
        Code Coverage is not covering Bottom Right and Right
        However, tried multiple ways and still is not.
         */
    }

    @Test
    public void isGameOverWhiteTest() {
        graphWhiteOver = new GameModelImplementation(2);
        graphWhiteOver.makePlay(0, 0, TileColor.WHITE);
        graphWhiteOver.makePlay(1, 0, TileColor.WHITE);
        assertTrue(graphWhiteOver.isGameOver());
    }

    @Test
    public void isGameOverBlackTest() {
        graphBlackOver = new GameModelImplementation(2);
        graphBlackOver.makePlay(0, 0, TileColor.BLACK);
        graphBlackOver.makePlay(0, 1, TileColor.BLACK);
        assertTrue(graphBlackOver.isGameOver());
    }
}

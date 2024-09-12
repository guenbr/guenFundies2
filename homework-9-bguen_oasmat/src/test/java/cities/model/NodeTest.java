package cities.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Graph.Node<String> mexico;
    Graph.Node<String> massachusetts;
    Graph.Node<String> newYork;
    Graph.Node<String> california;
    @BeforeEach
    public void setUp() {
        mexico = new Graph.Node<>("Mexico");
        massachusetts = new Graph.Node<>("MA");
        mexico.union(massachusetts);
        newYork = new Graph.Node<>("NY");
        mexico.union(newYork);
        california = new Graph.Node<>("CA");
        california.union(mexico);
    }
    @Test
    public void findTest() {
        assertEquals(mexico,massachusetts.find());
        assertEquals(mexico,newYork.find());
        assertEquals(mexico, california.find());
        assertEquals(mexico, mexico.find());

    }

    @Test
    public void unionTest() {
        assertEquals(mexico, massachusetts.getParent());
        assertEquals(mexico, newYork.getParent());
        assertEquals(mexico, california.getParent());
        assertEquals(mexico, california.getParent());
    }
    // Mistyped git commit as Finished MileStone 3 instead of Finished MileStone 2
}
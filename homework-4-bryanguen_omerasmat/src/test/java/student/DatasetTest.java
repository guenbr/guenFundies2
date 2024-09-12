package student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//anish and dylan helped us(TA)
//used stackoverflow for help on some errors

public class DatasetTest extends Dataset {

    //you have to initialize one or the other
    Dataset arrayListDataset;

    File[] expectedFileArray;


    Meow meow1;
    Meow meow2;
    Meow meow3;
    Meow meow4;
    Meow meow5;
    List<Meow> meowList;

    @BeforeEach
    public void setUp() {
        arrayListDataset = new ArrayListDataset();
        expectedFileArray = new File[]{
                new File("I_ANI01_MC_FN_SIM01_101.wav"),
                new File("B_ANI01_MC_FN_SIM01_103.wav"),
                new File("F_BAC01_MC_MN_SIM01_101.wav")
        };

        meow1 = new Meow(new File("I_ANI01_MC_FN_SIM01_101.wav"));
        meow2 = new Meow(new File("B_ANI01_MC_FN_SIM01_103.wav"));
        meow3 = new Meow(new File("F_BAC01_MC_MN_SIM01_101.wav"));
        meow4 = new Meow(new File("B_BAC01_MC_MN_SIM01_202.wav"));
        meow5 = new Meow(new File("I_ANI01_MC_FN_SIM01_101.wav"));

        meowList = new ArrayList<>();

    }

    @Test
    public void addEachToFrontTest() {
        arrayListDataset.addEachToFront(expectedFileArray);
        assertEquals(meow1, arrayListDataset.data.get(2));
        assertEquals(meow2, arrayListDataset.data.get(1));
        assertEquals(meow3, arrayListDataset.data.get(0));
    }

    @Test
    public void addEachToFrontBuggyTest() {
        File[] emptyFile = new File[0];
        arrayListDataset.addEachToFront(emptyFile);
        List<Dataset.Meow> list = new ArrayList<>();
        assertEquals(list, arrayListDataset.data);
    }

    @Test
    public void addEachToBackTest() {
        arrayListDataset.addEachToBack(expectedFileArray);
        assertEquals(meow1, arrayListDataset.data.get(0));
        assertEquals(meow2, arrayListDataset.data.get(1));
        assertEquals(meow3, arrayListDataset.data.get(2));
    }

    @Test
    public void addEachToBackBuggyTest() {
        meowList.add(new Meow(expectedFileArray[0]));
        meowList.add(new Meow(expectedFileArray[1]));
        meowList.add(new Meow(expectedFileArray[2]));
        arrayListDataset.addEachToBack(expectedFileArray);
        assertEquals(meowList, arrayListDataset.data);
    }

    @Test
    public void getRandomMeowTest() {
        arrayListDataset.addEachToBack(expectedFileArray);
        Meow storeRandom = arrayListDataset.getRandomMeow();
        assertTrue(arrayListDataset.data.contains(storeRandom));
    }

    @Test
    public void getRandomMeowIllegalTest() {
        assertThrows(IllegalStateException.class, () -> arrayListDataset.getRandomMeow());
    }

    @Test
    public void compareToTest() {
        // ANI compare to BACO return -1
        // BACO 202 compare BACO 101 return +1 b/c 202 should come after 101
        // ANI01 101 compare to ANI 103 return - 1
        assertEquals(-1, meow1.compareTo(meow3));
        assertEquals(1, meow4.compareTo(meow2));
        assertEquals(0, meow1.compareTo(meow5));
        assertEquals(0, meow1.compareTo(meow1));
    }

    @Test
    public void sortDatasetTest() {
        arrayListDataset.data.add(meow1);
        arrayListDataset.data.add(meow2);
        arrayListDataset.data.add(meow3);
        arrayListDataset.data.add(meow4);
        arrayListDataset.data.add(meow5);
        arrayListDataset.sortDataset();
        assertEquals(meow1, arrayListDataset.data.get(0));
        assertEquals(meow2, arrayListDataset.data.get(2));
        assertEquals(meow3, arrayListDataset.data.get(3));
        assertEquals(meow4, arrayListDataset.data.get(4));
        assertEquals(meow5, arrayListDataset.data.get(1));

    }
}



package student;

import java.awt.*;
import java.util.*;


/**
 * Keeps track of the functionality of a display on which a user can draw falling sand (and other
 * particles).
 */
public class SandLab {

    /**
     * Creates and runs a falling sand display with {@link #NUM_ROWS} rows and {@link #NUM_COLS} columns.
     */
    public static void main(String[] args) {
        SandDisplay display = new SandDisplay("Falling Sand", NUM_ROWS, NUM_COLS);
        SandLab lab = new SandLab(display);
        lab.run();
    }

    protected final ISandDisplay display;

    /**
     * The number of rows of the display to create.
     */
    public static final int NUM_ROWS = 120;

    /**
     * The number of columns of the display to create.
     */
    public static final int NUM_COLS = 80;
    private final Random rand;

    /**
     * Constructs a new SandLab display.
     *
     * @param display the GUI
     */
    public SandLab(ISandDisplay display) {
        this.display = display;
        rand = new Random();
    }

    /**
     * Updates the value in the grid to reflect the user painting that pixel using the given tool.
     *
     * @param row  row where the user clicked
     * @param col  column where the user clicked
     * @param tool Particle tool with which the user is painting. If the user is erasing, the tool is
     *             null.
     */
    protected void locationClicked(int row, int col, Particle tool) {
        display.setValue(row, col, tool);
    }
    // CheckPoint: Completed #5 to store the value using setValue.

    /**
     * Updates the display to show the right color in each pixel in the grid
     */
    public void updateDisplay() {
        // using a for loop to loop through each points
        // using a nested for loop it goes by each row by finishing col
        // Using an if statement for if particle is null will automatically make it black unless if it is selected
        for (int row = 0; row < display.getNumRows(); row++) {
            for (int col = 0; col < display.getNumCols(); col++) {
                Particle particle = display.getValue(row, col);
                if (particle == null) {
                    display.setColor(row, col, java.awt.Color.BLACK);
                } else if (particle == Particle.METAL) {
                    display.setColor(row, col, java.awt.Color.GRAY);
                } else if (particle == Particle.SAND) {
                    display.setColor(row, col, java.awt.Color.YELLOW);
                } else if (particle == Particle.WATER) {
                    display.setColor(row, col, java.awt.Color.CYAN);
                }
            }
        }
    }

    /**
     * Chooses a random spot on the grid, and if it contains a
     * particle, then moves that particle in a manner appropriate to the particle type.
     */
    // Without using a loop this function chooses a single random valid location and moves the particle there,
    // if there is one.
    public void step() {
        // This chooses a single random valid location when the func is called
        Random random = new Random();
        int row = random.nextInt(display.getNumRows() - 1);
        int col = random.nextInt(display.getNumCols());
        Particle particle = display.getValue(row, col);
        if (particle == Particle.SAND && display.getValue(row + 1, col) == null) {
            display.setValue(row + 1, col, Particle.SAND);
            display.setValue(row, col, null);
        } else if (particle == Particle.WATER) {
            int newDirection = random.nextInt(3);
            if (newDirection == 0 && display.getValue(row + 1, col) == null) {
                display.setValue(row + 1, col, Particle.WATER);
                display.setValue(row, col, null);
            } else if (col > 0 && newDirection == 1 && display.getValue(row + 1, col - 1) == null) {
                display.setValue(row + 1, col - 1, Particle.WATER);
                display.setValue(row, col, null);
            } else if (col < display.getNumCols() - 1 && newDirection == 2 && display.getValue(row + 1, col + 1) == null) {
                display.setValue(row + 1, col + 1, Particle.WATER);
                display.setValue(row, col, null);
            } else if (particle == Particle.SAND && display.getValue(row + 1, col) == Particle.WATER) {
                display.setValue(row + 1, col, Particle.SAND);
                display.setValue(row, col, Particle.WATER);
            }
        }
    }


    /**
     * Keeps the program running (updating the display based on mouseclicks) until the user quits the
     * program.
     */
    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++) {
                step();
            }
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null) { //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
            }
        }
    }
}
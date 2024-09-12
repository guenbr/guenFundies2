package student;

import java.util.ArrayList;
import java.util.List;

/**
 * A solver that can determine sets of appetizers that can be purchased
 * for a specified price.
 */
public class Solver {
    private final List<Appetizer> appetizers;
    private List<List<Appetizer>> solutions;

    /**
     * Creates a solver for the provided appetizers.
     *
     * @param appetizers the appetizers
     */
    public Solver(List<Appetizer> appetizers) {
        this.appetizers = appetizers;
        this.solutions = new ArrayList<>();
    }

    /**
     * Finds a single list of appetizers that can be purchased for
     * the specified price.
     *
     * @param totalPrice the total price
     * @return a single solution, or null if no solution exists
     */


    public List<Appetizer> findOneSolution(int totalPrice) {
        ArrayList<Appetizer> arrayListOneSolution = new ArrayList<>();
        solutionHelper(totalPrice, 0, arrayListOneSolution);
        if (solutions.isEmpty()) {
            return null;
        }
        return solutions.get(0);
    }

    private void solutionHelper(int remainPrice, int index, ArrayList<Appetizer> arrayListOneSolution) {
        if (remainPrice == 0) {
            solutions.add(new ArrayList<>(arrayListOneSolution));
            return;
        }
        for (int i = index; i < appetizers.size(); i++) {
            Appetizer getApp = appetizers.get(i);
            if (getApp.getPrice() <= remainPrice) {
                arrayListOneSolution.add(getApp);
                solutionHelper(remainPrice - getApp.getPrice(), i, arrayListOneSolution);
                arrayListOneSolution.remove(arrayListOneSolution.size() - 1);
            }
        }
    }


    /**
     * Finds all lists of appetizers that can be purchased for
     * the specified price.
     *
     * @param totalPrice the price in pennies
     * @return the solutions
     */
    public List<List<Appetizer>> findAllSolutions(int totalPrice) {
        ArrayList<Appetizer> arrayListOneSolution = new ArrayList<>();
        allSolutionHelper(totalPrice, 0, arrayListOneSolution);
        return new ArrayList<>(solutions);
    }

    private void allSolutionHelper(int remainPrice, int index, ArrayList<Appetizer> arrayListOneSolution) {
        if (remainPrice == 0) {
            solutions.add(new ArrayList<>(arrayListOneSolution));
            return;
        }
        for (int i = index; i < appetizers.size(); i++) {
            Appetizer getApp = appetizers.get(i);
            if (getApp.getPrice() <= remainPrice) {
                arrayListOneSolution.add(getApp);
                allSolutionHelper(remainPrice - getApp.getPrice(), i, arrayListOneSolution);
                arrayListOneSolution.remove(arrayListOneSolution.size() - 1);
            }
        }
    }
}

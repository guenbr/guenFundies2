package student;

import java.util.Objects;

/**
 * An appetizer that can be ordered in any quantity.
 */
public class Appetizer implements Comparable<Appetizer> {
    private String name;
    private int price; // pennies

    private final int moneyConversion = 100;

    /**
     * Creates an appetizer with the specified name and price.
     *
     * @param name the name
     * @param price the price in pennies
     */
    public Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of this appetizer.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of this appetizer.
     *
     * @return the price in pennies
     */
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        int dollar = price / moneyConversion;
        int cents = price % moneyConversion;
        return String.format("%s ($" + dollar + "." + cents + ")", name);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Appetizer other = (Appetizer) object;
        return Objects.equals(name, other.name) && price == other.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Appetizer other) {
        int comparison = name.compareTo(other.name);
        if (comparison > 0) {
            return 1;
        } else if (comparison < 0) {
            return -1;
        } else {
            return Integer.compare(price, other.price);
        }
    }
}

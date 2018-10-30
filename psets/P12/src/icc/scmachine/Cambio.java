/**
* Cambio represent the set of spare change needed to
* represent an integer amount, in other words, the sum
* of the amounts of each value will add up to an specific
* desired total.
*
* @author Pablo Trinidad <github.com/pablotrinidad>
*/

package icc.scmachine;

// Lang libraries
import java.util.ArrayList;
import java.util.Arrays;


public class Cambio {

    // Initial list containing spare change values.
    private int[] units;

    private int onesAmount; // Represent the amount of coins with value of $1
    private int twosAmount; // Represent the amount of coins with value of $2
    private int fivesAmount; // Represent the amount of coins with value of $5
    private int tensAmount; // Represent the amount of coins with value of $10

    private int totalValue; // Sum of all coins

    public Cambio(int[] units) {
        this.units = units;
        this.parseAmounts(units);
    }

    // Return sum of all coins
    public int getTotalValue() {
        return this.totalValue;
    }

    // onesAmount getter
    public int getOnesAmount() { return this.onesAmount; }

    // twosAmount getter
    public int getTwosAmount() { return this.twosAmount; }

    // fivesAmount getter
    public int getFivesAmount() { return this.fivesAmount; }

    // tensAmount getter
    public int getTensAmount() { return this.tensAmount; }

    // Assign each coin value an amount from given units list
    private void parseAmounts(int[] units) {
        for (int i=0; i<units.length; i++) {
            if (units[i] == 1) { this.onesAmount += 1; }
            if (units[i] == 2) { this.twosAmount += 1; }
            if (units[i] == 5) { this.fivesAmount += 1; }
            if (units[i] == 10) { this.tensAmount += 1; }
        }
    }

    // Return string representation of the units array
    public String toString() {
        return Arrays.toString(this.units);
    }
}

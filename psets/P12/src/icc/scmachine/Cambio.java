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
    }

    // Return sum of all coins
    public int getTotalValue() {
        return this.totalValue;
    }

    public String toString() {
        return Arrays.toString(this.units);
        // String rep = "";
        // for (int i=0; i<this.units.length; i++) {
        //     rep += Integer.toString(this.units[i]);
        //     rep += ", ";
        // }
        // return rep.length() > 0 ? rep.substring(0, rep.length() - 2) : "";
    }
}

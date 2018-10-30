/**
* Cambio represent the set of spare change needed to
* represent an integer amount, in other words, the sum
* of the amounts of each value will add up to an specific
* desired total.
*
* @author Pablo Trinidad <github.com/pablotrinidad>
*/

package icc.scmachine;


public class Cambio {

    // Initial list containing spare change values.
    private int[] units;

    private int onesAmount; // Represent the amount of coins with value of $1
    private int twosAmount; // Represent the amount of coins with value of $2
    private int fivesAmount; // Represent the amount of coins with value of $5
    private int tensAmount; // Represent the amount of coins with value of $10

    public Cambio(int[] units) {
        this.units = units;
    }
}

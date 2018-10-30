/**
* MaquinaDeCambio expose the methods for obtaining all the
* possible subsets of spare change (Cambio objects) from
* a given integer.
*
* @author Pablo Trinidad <github.com/pablotrinidad>
*/

package icc.scmachine;

// Lang libraries
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MaquinaDeCambio {

    // 1 is not included since it's generated as the starting node of the recursive algorithm.
    private int[] coinsSet = {2, 5, 10};

    // Public method for computing all possible spare change combinations.
    public ArrayList<Cambio> computeSpareChangeSets(int n) {
        // Validate input
        if (n < 1) { throw new IllegalArgumentException(Integer.toString(n)); }

        HashMap<String, Cambio> map = new HashMap<String, Cambio>();
        map = this.computeSets(
            n, // Integer target
            this.coinsSet,
            this.getInitialCombination(n), // Return initial node (n-sized list of 1s)
            map
        );

        // Insert map values into array
        ArrayList<Cambio> results = new ArrayList<Cambio>(map.values());
        return results;
    }

    // Private method that handle recursive calls and holds the main algorithm.
    private HashMap<String, Cambio> computeSets(int n, int[] coins, int[] comb, HashMap<String, Cambio> memo) {
        // The algorithm is based in a depth-first search tree, dynamic programming
        // approach is used to avoid recomputing branches. Although the DP approach
        // makes the algorithm run faster, it should be noted that this problem is
        // a variant of a 1/0 knapsack optimization problem so no polynomial solutions
        // exist. This can also be perceived as a restricted partition and because we
        // know that partitions grow exponentially, we can assume this will do as well.
        // https://en.wikipedia.org/wiki/Partition_(number_theory)#Restricted_partitions

        String combId = this.genCombId(comb);

        // Execute algorithm only if combination hasn't being memorized before.
        if ((memo.get(combId)) == null) {
            memo.put(combId, new Cambio(comb));

            for (int i=0; i<coins.length; i++) {
                // This will tell us if it is possible to create a new branch from current comb
                int c = coins[i];
                for (int j=0; j<comb.length; j++) {
                    if (comb[j] < coins[i]) {
                        c -= comb[j];
                    }
                    if (c == 0) {
                        // Create new sorted branch and apply recursion.
                        int branchCopy[] = Arrays.copyOfRange(comb, j+1, comb.length);
                        int branch[] = new int[branchCopy.length + 1];
                        for (int k=0; k<branchCopy.length; k++) { branch[k] = branchCopy[k]; }
                        branch[branch.length-1] = coins[i];
                        Arrays.sort(branch);
                        memo = computeSets(n, coins, branch, memo);
                        break;
                    }
                }

                if (c < 0) { break; }
            }
        }
        return memo;
    }

    // Return n-sized list of 1s
    private int[] getInitialCombination(int n) {
        int[] node = new int[n];
        for (int i=0; i<n; i++) { node[i] = 1; }
        return node;
    }

    // Return string containing all elements of the list.
    private String genCombId(int[] comb) {
        String id = "";
        for(int i=0; i<comb.length; i++) { id += Integer.toString(comb[i]); }
        return id;
    }
}

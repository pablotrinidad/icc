package icc.ajedrez;
import java.util.*;

public class UsoAjedrez {

    public static void main(String[] args) {
        List<List<Integer>> cells = genCells();
        for(int i = 0; i < cells.size(); i++) {
            char column = (char) (int) cells.get(i).get(1);
            int row = cells.get(i).get(0);
            Reina r = new Reina(column, row);
            System.out.println("Creando nueva reina:");
            System.out.println("\t" + r);
            System.out.println("\tPosibles movimientos: " + r.posiblesMovimientos());
        }
    }

    public static List<List<Integer>> genCells() {
        List<List<Integer>> cellsPermutations = new ArrayList<>();
        for(int i=1; i < 9; i++) {
            for (int j=97; j < 105; j++){
                List<Integer> level = new ArrayList<Integer>();
                level.add(i); level.add(j);
                cellsPermutations.add(level);
            }
        }
        return cellsPermutations;
    }

}

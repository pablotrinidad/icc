package icc.ajedrez;
import java.util.*;

public class UsoAjedrez {

    public static void main(String[] args) {
        List<List<Integer>> cells = genCells();

        // Genera una reina en cada una de las posibles casillas
        for(int i = 0; i < cells.size(); i++) {
            char column = (char) (int) cells.get(i).get(1);
            int row = cells.get(i).get(0);
            Reina r = new Reina(column, row);

            // Evalua los posibles movimientos de la reina en dicha casilla
            System.out.println("Creando nueva " + r);
            System.out.println("\tPosibles movimientos: " + r.posiblesMovimientos());
        }

        System.out.println("\n\n");

        // Genera un caballo en cada una de las posibles casillas
        for(int i = 0; i < cells.size(); i++) {
            char column = (char) (int) cells.get(i).get(1);
            int row = cells.get(i).get(0);
            Caballo c = new Caballo(column, row);

            // Evalua los posibles movimientos del caballo en dicha casilla
            System.out.println("Creando nuevo " + c);
            System.out.println("\tPosibles movimientos: " + c.posiblesMovimientos());
        }

        System.out.println("\n\n");

        // Genera un caballo en cada una de las posibles casillas
        for(int i = 0; i < cells.size(); i++) {
            char column = (char) (int) cells.get(i).get(1);
            int row = cells.get(i).get(0);
            Caballo c = new Caballo(column, row);

            // Evalua los posibles movimientos del caballo en dicha casilla
            System.out.println("Creando nuevo " + c);
            System.out.println("\tPosibles movimientos: " + c.posiblesMovimientos());
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

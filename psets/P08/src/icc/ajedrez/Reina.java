/**
* ICC Práctica 08
* Reina.java
* Propósito: Abstraer el comportamiento de una Reina en ajedrez.
*
* @author Pablo Trinidad (github.com/pablotrinidad)
* @version 1.0 10/07/2018
*/

package icc.ajedrez;
import java.util.*;


public class Reina extends Pieza {

    Posicion posicion;

    /** Constructor principal
    * @param columna        Columna
    * @param renglón        Renglón
    *
    * Genera nueva reina en la posición recibida.
    */
    public Reina(char columna, int renglon) {
        this.posicion = new Posicion(columna, renglon);
    }

    public ArrayList<Posicion> posiblesMovimientos() {
        ArrayList movements = new ArrayList<Posicion>();
        List<List<Integer>> cellsPermutations = this.genCellExpansions();

        int startingColumn = this.posicion.getColumna();
        int startingRow = (int) this.posicion.getRenglon();

        for(int i=1; i<8; i++) {

            // Iterate over the cell permutations
            for (int j=0; j < 8; j++) {
                int xDifference = i * cellsPermutations.get(j).get(0);
                int yDifference = i * cellsPermutations.get(j).get(1);

                int newX = startingColumn + xDifference;
                int newY = startingRow + yDifference;

                // Si la nueva coordenada sigue dentro de los límites
                if (!this.posicion.columnOutOfBound(newX) && !this.posicion.rowOutOfBound(newY)) {
                    movements.add(new Posicion((char) newX, newY));
                }
            }
        }
        return movements;
    }

    public boolean esValida(int renglon, char columna) {
        Posicion p = new Posicion(columna, renglon);
        ArrayList<Posicion> validMovements = this.posiblesMovimientos();
        boolean isValid = false;
        for(int i = 0; i < validMovements.size(); i++) {
            if (validMovements.get(i).equals(p)) { isValid = true; }
        }
        return isValid;
    }

    /** genCellExpansions
    * @return Genera una lista de listas de enteros conteniendo
    *         los valores que multiplicados por una iteración generán
    *         el crecimiento deseado en diagonal, horizontal y vertical.
    */
    public List<List<Integer>> genCellExpansions() {
        List<List<Integer>> cellsPermutations = new ArrayList<>();
        for (int i=-1; i < 2; i++) {
            for (int j=-1; j < 2; j++) {
                if (i != 0 || j != 0) { // Exclude 0,0
                    List<Integer> level = new ArrayList<Integer>();
                    level.add(i);
                    level.add(j);
                    cellsPermutations.add(level);
                }
            }
        }
        return cellsPermutations;
    }

    /** toString
    * @return Una representación en String de la pieza
    */
    public String toString() {
        return "Reina: " + this.posicion;
    }

}

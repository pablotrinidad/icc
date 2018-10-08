/**
* ICC Práctica 08
* Caballo.java
* Propósito: Abstraer el comportamiento de un caballo en ajedrez.
*
* @author Pablo Trinidad (github.com/pablotrinidad)
* @version 1.0 10/07/2018
*/

package icc.ajedrez;
import java.util.*;


public class Caballo extends Pieza {

    Posicion posicion;

    /** Constructor principal
    * @param columna        Columna
    * @param renglón        Renglón
    *
    * Genera nuevo caballo en la posición recibida.
    */
    public Caballo(char columna, int renglon) {
        this.posicion = new Posicion(columna, renglon);
    }

    /** posiblesMovimientos
    * @return Dada una pieza, debe regresas una lista de las
    *         posibles posiciones que puede tomar.
    */
    public ArrayList<Posicion> posiblesMovimientos() {
        ArrayList movements = new ArrayList<Posicion>();
        List<List<Integer>> cellsPermutations = this.genCellExpansions();

        int startingColumn = this.posicion.getColumna();
        int startingRow = (int) this.posicion.getRenglon();

        for(int i=0; i < cellsPermutations.size(); i++) {
            int newX = startingColumn + cellsPermutations.get(i).get(0);
            int newY = startingRow + cellsPermutations.get(i).get(1);
            if (!this.posicion.columnOutOfBound(newX) && !this.posicion.rowOutOfBound(newY)) {
                movements.add(new Posicion((char) newX, newY));
            }
        }
        return movements;
    }

    /** genCellExpansions
    * @return Genera una lista de listas de enteros conteniendo
    *         los valores que multiplicados por una iteración generán
    *         el crecimiento deseado en diagonal, horizontal y vertical.
    */
    public List<List<Integer>> genCellExpansions() {
        List<List<Integer>> cellsPermutations = new ArrayList<>();
        for(int i=1; i<3; i++) {
            for(int j=-1; j < 2; j += 2) {
                List<Integer> l1 = new ArrayList<Integer>();
                l1.add((i * j)); l1.add((3 - i));

                List<Integer> l2 = new ArrayList<Integer>();
                l2.add((i * j)); l2.add(-(3 - i));

                cellsPermutations.add(l1);
                cellsPermutations.add(l2);
            }
        }
        return cellsPermutations;
    }


    /** toString
    * @return Una representación en String de la pieza
    */
    public String toString() {
        return "Caballo: " + this.posicion;
    }

}

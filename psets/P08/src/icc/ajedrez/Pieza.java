/**
* ICC Práctica 08
* Pieza.java
* Propósito: Abstraer el comportamiento de una pieza de ajedrez
*
* @author Pablo Trinidad (github.com/pablotrinidad)
* @version 1.0 10/07/2018
*/

package icc.ajedrez;
import java.util.*;

abstract public class Pieza {

    /** posiblesMovimientos
    * @return Dada una pieza, debe regresas una lista de las
    *         posibles posiciones que puede tomar.
    */
    abstract ArrayList<Posicion> posiblesMovimientos();

    /** esValida
    * @param renglon    Renglón al que se planea mover
    * @param columna    Columna a la que se planea mover
    *
    * @return Un booleando indicando si sería válido mover
    *         la pieza desde su posición actual hasta la
    *         posición indicada en los parámetros.
    */
    abstract boolean esValida(int renglon, char columna);

}

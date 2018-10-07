/**
* ICC Práctica 08
* Posicion.java
* Propósito: Almacenar la posición de una pieza de ajedrez
*            computesta por renglón y columna
*
* @author Pablo Trinidad (github.com/pablotrinidad)
* @version 1.0 10/07/2018
*/

package icc.ajedrez;

public class Posicion {
    public short renglon;
    public char columna;

    /** Constructor principal
    * @param renglon        Renglón
    * @param columna        Columna
    *
    * Asigna los valores recibidos usando la validación de los setters
    */
    public Posicion (short renglon, char columna) {
        this.setRenglon(renglon);
        this.setColumna(columna);
    }

    /* Getter de renglón */
    public short getRenglon() { return this.renglon; }

    /** Setter de renglón
    * @param renglon        Renglón
    *
    * Valida la entrada y asigna el valor recibido al renglón
    */
    public void setRenglon(short renglon) {
        // Verifica que el valor esté en el rango válido
        boolean valid = false;
        for (short i=1; i < 9; i++) {
            if (renglon == i) { valid = true; }
        }

        // Lanza exception si no lo está
        if (valid == false) {
            throw new IllegalArgumentException();
        }

        this.renglon = renglon;
    }

    /* Getter de columna */
    public char getColumna() { return this.columna; }

    /** Setter de columna
    * @param columna        Columna
    *
    * Valida la entrada y asigna el valor recibido a la columna
    */
    public void setColumna(char columna) {
        // Verifica que el valor esté en el rango válido (definido por ASCII)
        boolean valid = false;
        for (int i=97; i < 105; i++) {
            if ((int) columna == i) { valid = true; }
        }

        // Lanza exception si no lo está
        if (valid == false) {
            throw new IllegalArgumentException();
        }

        this.columna = columna;
    }

    /** toString
    * @return Regresa las "coordenadas" de la posición.
    */
    public String toString() {
        return "(" + this.columna + ", " + this.renglon + ")";
    }

}

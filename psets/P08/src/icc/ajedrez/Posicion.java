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
    public int renglon;
    public char columna;

    /** Constructor principal
    * @param renglon        Renglón
    * @param columna        Columna
    *
    * Asigna los valores recibidos usando la validación de los setters
    */
    public Posicion(char columna, int renglon) {
        this.setRenglon(renglon);
        this.setColumna(columna);
    }

    /* Getter de renglón */
    public int getRenglon() { return this.renglon; }

    /** Setter de renglón
    * @param renglon        Renglón
    *
    * Valida la entrada y asigna el valor recibido al renglón
    */
    public void setRenglon(int renglon) {
        // Verifica que el valor esté en el rango válido
        if (this.rowOutOfBound(renglon)) {
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
        if (this.columnOutOfBound((int) columna)) {
            throw new IllegalArgumentException();
        }

        this.columna = columna;
    }

    /** Setter custom de posición
    * @param renglon        Renglón
    * @param columna        Columna
    *
    * Valida la entrada y asigna el valor recibido a la columna y renglón.
    * Evita la llamada a ambos métodos
    */
    public void set(char columna, int renglon) {
        this.setRenglon(renglon);
        this.setColumna(columna);
    }

    /** toString
    * @return Regresa las "coordenadas" de la posición.
    */
    public String toString() {
        return "(" + this.columna + ", " + this.renglon + ")";
    }

    /** equals
    * @return Compara ambos objetos por coordenadas
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (this == null) { return true; }
        if (getClass() != o.getClass()) { return false; }

        Posicion p = (Posicion) o;
        return(columna == p.getColumna()) && (renglon == p.getRenglon());

    }

    /** rowOutOfBound
    * @param row        Renglón
    *
    * @return Regresa un booleano indicando si el renglón se encuentra fuera
    *         de los límites del tablero
    */
    public boolean rowOutOfBound(int row) {
        return (row < 1 || row > 8);
    }

    /** columnOutOfBound
    * @param column        Columna (valor ASCII)
    *
    * @return Regresa un booleano indicando si la columna se encuentra fuera
    *         de los límites del tablero
    */
    public boolean columnOutOfBound(int column) {
        return (column < 97 || column > 104);
    }


}

/* -*- jde -*- */
/* <ManejadorDeLista.java> */

package icc.util;

/**
 * Clase para proveer los servicios de un contenedor tipo Lista.
 */
public class ManejadorDeLista {

    /**
     * Primer elemento de la lista.
     */
    private Lista cabeza;

    /**
     * Número de elementos en la lista.
     */
    private int longitud;

    /**
     * Agrega un registro agenda al final de la lista.
     */
    public void agrega(Object elemento) {
        // Crea el nuevo elemento y lo cuenta.
        Lista nuevo = new Lista(elemento);
        longitud++;

        // Si la lista está vacía añade al primer elemento y termina.
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        // Si no, hay que recorrer la lista para formar al nuevo
        // elemento detrás del último.
        Lista anterior = cabeza;
        while(anterior.getSiguiente() != null) {
            anterior = anterior.getSiguiente();
        }
        anterior.setSiguiente(nuevo);
    }

    /**
     * Devuelve el número de elementos en esta lista.
     */
    public int longitud() {
        return longitud;
    }

    /**
     * Por ahora utilizaremos este método para poder
     * programar la búsqueda en la base de datos.
     */
    public Object encuentra(Buscador buscador) {
        if (this.cabeza == null) { return null; }

        Object current = cabeza.getElemento();
        Lista currentManager = cabeza;
        while(current != null) {
            if (buscador.esEste(current)) {
                return current;
            }
            currentManager = currentManager.getSiguiente();
            current = currentManager != null ? currentManager.getElemento() : null;
        }

        return null;
    }

}

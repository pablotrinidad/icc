/** Clase Contactos
* Almacena los datos de cada contacto.
*
*  @author Pablo Trindiad <github.com/pablotrinidad>
*/

package icc.contactos;

public class Contactos {

    // Almacena el primer primer contacto
    Registro cabeza = null;

    /** insertaContacto
    *
    * @param reg        Nuevo registro por insertar
    * @return Inserta un nuevo contacto (ordenado alfabéticamente) en el registro
    */
    public void insertaContacto(Registro nuevoContacto) {
        // Si no hay cabeza, usa el registro como la cabea
        if (this.cabeza == null) { this.cabeza = nuevoContacto; }

        // Si el dato recibido no es nulo
        if (nuevoContacto != null) {
            Registro contactoActual = this.cabeza;
            Registro ultimoContacto = contactoActual;
            while (contactoActual != null) {
                contactoActual = contactoActual.getSiguiente();
                ultimoContacto = contactoActual;
            }

            // Registro contactoActual = this.cabeza;
            // Registro ultimoContacto = this.cabeza;

            // while (contactoActual != null) {
            //     if (contactoActual.getNombre().compareTo(nuevoNombre) >= 0) {
            //         ultimoContacto = contactoActual;
            //         contactoActual = contactoActual.getSiguiente();
            //     } else {
            //         ultimoContacto.siguiente = nuevoContacto;
            //         nuevoContacto = contactoActual;
            //         nombreActual
            //     }

            // }
        }
    }

    /** imprimeContactos
    *
    * @return Sigue los links de cada contacto e imprime su representación en String
    */
    public void imprimeContactos() {
        Registro contactoActual = this.cabeza;
        while (contactoActual != null) {
            System.out.println(contactoActual);
            contactoActual = contactoActual.getSiguiente();
        }
    }

    /** consultar
    *
    * @return Busca y regresa el primer contacto que contenga la cadena recibida
    */
    public Registro consultar(String query) {
        Registro contactoActual = this.cabeza;
        while (contactoActual != null) {
            if (contactoActual.getNombre().contains(query)) {
                return contactoActual;
            }
            contactoActual = contactoActual.getSiguiente();
        }
        return null;
    }
}

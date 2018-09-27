/** Clase Contactos
* Almacena los datos de cada contacto.
*
*  @author Pablo Trindiad <github.com/pablotrinidad>
*/

package icc.contactos;

public class Contactos {

    // Almacena el primer primer contacto
    Registro head = null;

    /** insertaContacto
    *
    * @param reg Nuevo registro por insertar
    * @return Inserta un nuevo contacto (ordenado alfabéticamente) en el registro
    */
    public void insertaContacto(Registro newContact) {
        if (this.head == null) {
            this.head = newContact;
        }
        else {
            Registro currentContact = this.head;
            Registro lastContact = null;
            String currentName, newName, shortestName;
            Boolean sorted = false;

            // Itera mientras haya un siguiente contacto y los links no estén ordenados
            while (currentContact != null && sorted == false) {
                currentName = currentContact.getNombre();
                newName = newContact.getNombre();

                if (currentName.compareToIgnoreCase(newName) > 0) {
                    if (lastContact == null) { // Hay sólo un elemento en la lista
                        this.head = newContact;
                    } else { // Hay múltiples elementos en la lista
                        lastContact.setSiguiente(newContact);
                    }

                    newContact.setSiguiente(currentContact);
                    sorted = true;
                } else {
                    if (currentContact.getSiguiente() == null) { // Se llegó al final de la lista
                        currentContact.setSiguiente(newContact);
                        sorted = true;
                    }
                }

                lastContact = currentContact;
                currentContact = currentContact.getSiguiente();
            }
        }
    }

    /** imprimeContactos
    *
    * @return Sigue los links de cada contacto e imprime su representación en String
    */
    public void imprimeContactos() {
        System.out.println(
            String.join("\t|\t", "Nombre", "Teléfono", "Dirección") + "\n" +
            "=================================================="
        );
        Registro contactoActual = this.head;
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
        Registro contactoActual = this.head;
        while (contactoActual != null) {
            if (contactoActual.getNombre().contains(query)) {
                return contactoActual;
            }
            contactoActual = contactoActual.getSiguiente();
        }
        return null;
    }
}

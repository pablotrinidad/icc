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

            // Itera mientras haya un siguiente contacto y los link no estén ordenados
            while (currentContact != null && sorted == false) {
                currentName = currentContact.getNombre();
                newName = newContact.getNombre();
                shortestName = currentName.length() > newName.length() ? newName : currentName;

                /* Itera en las letras de la cadena más corta
                * Se hace por las cadenas que repitan caracteres, por ejemplo:
                * "Aaron" y "Angel" o "Luis Alberto" y "Luis Enrique"
                */
                for (int i = 0; i < shortestName.length(); i++) {
                    Character cChar = Character.toUpperCase(currentName.charAt(i));
                    Character nChar = Character.toUpperCase(newName.charAt(i));

                    if (cChar > nChar) {
                        if (lastContact == null) {
                            this.head = newContact;
                            newContact.setSiguiente(currentContact);
                        } else {
                            lastContact.setSiguiente(newContact);
                            newContact.setSiguiente(currentContact);
                        }
                        sorted = true;
                        break;
                    }
                    else if (cChar < nChar) {
                        if (currentContact.getSiguiente() == null) {
                            currentContact.setSiguiente(newContact);
                            sorted = true;
                        }
                        break;
                    }
                }
                lastContact = currentContact;
                currentContact = currentContact.getSiguiente();
            }
            if (lastContact != null) {
                if (lastContact.getSiguiente() != newContact && newContact.getSiguiente() == null) {
                    lastContact.setSiguiente(newContact);
                    newContact.setSiguiente(currentContact);
                }
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

/** Clase Registro
* Almacena los datos de cada contacto.
*
*  @author Pablo Trindiad <github.com/pablotrinidad>
*/

package icc.contactos;


public class Registro {

    public String nombre = "Default contact name";
    public String direccion = "Default contact address";
    public String telefono = "+XX XX XXXX XXXX";

    public Registro siguiente = null;

    /** Constructor principal
    * @param nombre         Nombre del contacto
    * @param direccion      Direccion del contacto
    * @param telefono       Teléfono del contacto
    *
    * @return Asigna valores recibidos a cada variable, sólo si no son nulos
    */
    public Registro (String nombre, String direccion, String telefono){
        if (nombre != null) { this.nombre = nombre; }
        if (direccion != null) { this.direccion = direccion; }
        if (telefono != null) { this.telefono = telefono; }
    }

    /* Getter de nombre */
    public String getNombre() { return this.nombre; }

    /** Setter de nombre
    * @param nombre     Nombre del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setNombre(String nombre) {
        if (nombre != null) { this.nombre = nombre; }
    }

    /* Getter de direccion */
    public String getDireccion() { return this.direccion; }

    /** Setter de direccion
    * @param direccion     Dirección del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setDireccion(String direccion) {
        if (direccion != null) { this.direccion = direccion; }
    }

    /* Getter de telefono */
    public String getTelefono() { return this.telefono; }

    /** Setter de telefono
    * @param telefono     Teléfono del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setTelefono(String telefono) {
        if (telefono != null) { this.telefono = telefono; }
    }

    /** toString
    * @return Regresa los datos de la clase unidos por un espacio
    */
    public String toString() {
        return String.join(" ", this.nombre, this.telefono, this.direccion);
    }

    /* Getter del siguiente contact */
    public Registro getSiguiente() {
        return this.siguiente;
    }

    /** Setter de siguiente contacto
    * @param siguiente     Siguiente contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setSiguiente(Registro siguiente) {
        if (siguiente != null) { this.siguiente = siguiente; }
    }

}

/* -*- jde -*- */
/* <RegistroAgenda.java> */

package icc.agenda;


/**
 * Registro para una Agenda
 */
public class RegistroAgenda {

    private String nombre;
    private String direccion;
    private int telefono;

    /** Constructor principal
    * @param nombre         Nombre del contacto
    * @param direccion      Direccion del contacto
    * @param telefono       Teléfono del contacto
    *
    * @return Asigna valores recibidos a cada variable, sólo si no son nulos
    */
    public RegistroAgenda(String nombre, String direccion, int telefono){
        this.nombre = nombre.length() != 0 ? nombre : "Default contact name";
        this.direccion = direccion.length() != 0 ? direccion : "Default contact address";
        this.telefono = telefono;
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
    public int getTelefono() { return this.telefono; }

    /** Setter de telefono
    * @param telefono     Teléfono del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /** toString
    * @return Regresa los datos de la clase unidos por un espacio
    */
    public String toString() {
        return String.join(" | ", this.nombre, Integer.toString(this.telefono), this.direccion);
    }
}

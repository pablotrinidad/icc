/* -*- jde -*- */
/* <Reloj.java> */

package icc.practica1;

/**
 * Interfaz de Reloj. Define qué servicios provee un Reloj; en este caso
 * modificar y obtener su estado.
 * @author Canek
 */
public interface Reloj {

    /** Horas por día */
    public static final int HORAS_POR_DIA       = 12;
    /** Minutos por hora */
    public static final int MINUTOS_POR_HORA    = 60;
    /** Segundos por minuto */
    public static final int SEGUNDOS_POR_MINUTO = 60;

    /**
     * Pone el tiempo del Reloj como el tiempo del sistema al
     * momento de llamar esta función.
     */
    public void ponTiempo();

    /**
     * Pone el tiempo del Reloj.
     * @param hora la nueva hora.
     * @param minuto el nuevo minuto.
     * @param segundo el nuevo segundo.
     */
    public void ponTiempo(int hora, int minuto, int segundo);

    /**
     * Pone únicamente la hora del Reloj, cuidando que esté
     * en el rango 0-11.
     * @param hora la nueva hora.
     */
    public void setHora(int hora);

    /**
     * Pone únicamente el minuto del Reloj, cuidando que esté
     * en el rango 0-59.
     * @param minuto el nuevo minuto.
     */
    public void setMinuto(int minuto);

    /**
     * Pone únicamente el segundo del Reloj, cuidando que esté
     * en el rango 0-59.
     * @param segundo el nuevo segundo.
     */
    public void setSegundo(int segundo);

    /**
     * Regresa la hora en que está el Reloj.
     * @return la hora del Reloj.
     */
    public int getHora();
    
    /**
     * Regresa el minuto en que está el Reloj.
     * @return el minuto del Reloj.
     */
    public int getMinuto();

    /**
     * Regresa el segundo en que está el Reloj.
     * @return el segundo del Reloj.
     */
    public int getSegundo();

    /**
     * Avanza el Reloj en un segundo.
     * Si al avanzar el segundo se pasa de 59, regresa el
     * segundo a 0 y avanza el minuto en uno. Si al avanzar
     * el minuto pasa de 59, avanza la hora en uno. Y si al
     * avanzar la hora pasa de 11, la regresa a 0.
     */
    public void avanzaSegundo();
    
    /**
     * Avanza el Reloj en un minuto.
     * Si al avanzar el Reloj en un minuto pasa de 59, avanza
     * la hora en uno. Y si al avanzar la hora pasa de 11,
     * la regresa a 0.
     */
    public void avanzaMinuto();

    /**
     * Avanza el Reloj en una hora.
     * Si al avanzar la hora pasa de 11, la regresa a 0.
     */
    public void avanzaHora();

    /**
     * Retrasa el Reloj un segundo.
     */
    public void retrasaSegundo();

    /**
     * Retrasa el Reloj un minuto.
     */
    public void retrasaMinuto();

    /**
     * Retrasa el Reloj una hora.
     */
    public void retrasaHora();
}

/* </Reloj.java> */

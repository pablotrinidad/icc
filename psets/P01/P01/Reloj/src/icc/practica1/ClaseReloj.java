/* -*- jde -*- */
/*  <ClaseReloj.java>  */

package icc.practica1;

import java.util.Calendar;

/**
 * Clase para representar un Reloj.<p>
 *
 * Un objeto de la clase ClaseReloj implementa todos los métodos de la clase
 * Reloj, por lo que es capaz de definir su hora y darla, además de avanzar
 * (o retroceder) por segundos, minutos u horas.
 * @author Canek
 */
public class ClaseReloj implements Reloj {

    /** La hora del reloj. */
    private int hora;
    /** El minuto del reloj. */
    private int minuto;
    /** El segundo del reloj. */
    private int segundo;

    /**
     * Constructor simple. Regresa un Reloj con la hora actual
     * del sistema.
     */
    public ClaseReloj() {
		this.ponTiempo();
    }

    /**
     * Constructor para definirle un tiempo específico.
     * @param hora la hora.
     * @param minuto el minuto.
     * @param segundo el segundo.
     */
    public ClaseReloj(int hora, int minuto, int segundo) {
		this.ponTiempo(hora,minuto,segundo);
    }

    /**
     * Pone el tiempo del Reloj como el tiempo del sistema al
     * momento de llamar esta función.
     */
    public void ponTiempo() {
		Calendar c    = Calendar.getInstance();
		this.hora     = c.get(Calendar.HOUR_OF_DAY) % Reloj.HORAS_POR_DIA;
		this.minuto   = c.get(Calendar.MINUTE) % Reloj.MINUTOS_POR_HORA;
		this.segundo  = c.get(Calendar.SECOND) % Reloj.SEGUNDOS_POR_MINUTO;
    }

    /**
     * Pone el tiempo del Reloj.
     * @param hora la nueva hora.
     * @param minuto el nuevo minuto.
     * @param segundo el nuevo segundo.
     */
    public void ponTiempo(int hora, int minuto, int segundo) {
		this.setHora(hora);
		this.setMinuto(minuto);
		this.setSegundo(segundo);
    }

    /**
     * Pone únicamente la hora del Reloj, cuidando que esté
     * en el rango 0-11.
     * @param hora la nueva hora.
     */
    public void setHora(int hora) {
		this.hora = Math.abs(hora) % Reloj.HORAS_POR_DIA;
    }

    /**
     * Pone únicamente el minuto del Reloj, cuidando que esté
     * en el rango 0-59.
     * @param minuto el nuevo minuto.
     */
    public void setMinuto(int minuto) {
		this.minuto = Math.abs(minuto) % Reloj.MINUTOS_POR_HORA;
    }

    /**
     * Pone únicamente el segundo del Reloj, cuidando que esté
     * en el rango 0-59.
     * @param segundo el nuevo segundo.
     */
    public void setSegundo(int segundo) {
		this.segundo = Math.abs(segundo) % Reloj.SEGUNDOS_POR_MINUTO;
    }

    /**
     * Regresa la hora en que está el Reloj.
     * @return la hora del Reloj.
     */
    public int getHora() {
		return this.hora;
    }
    
    /**
     * Regresa el minuto en que está el Reloj.
     * @return el minuto del Reloj.
     */
    public int getMinuto() {
		return this.minuto;
    }

    /**
     * Regresa el segundo en que está el Reloj.
     * @return el segundo del Reloj.
     */
    public int getSegundo() {
		return this.segundo;
    }

    /**
     * Avanza el Reloj en un segundo.
     * Si al avanzar el segundo se pasa de 59, regresa el
     * segundo a 0 y avanza el minuto en uno. Si al avanzar
     * el minuto pasa de 59, avanza la hora en uno. Y si al
     * avanzar la hora pasa de 11, la regresa a 0.
     */
    public void avanzaSegundo() {
		this.segundo++;
		if (this.segundo >= Reloj.SEGUNDOS_POR_MINUTO) {
			this.segundo = 0;
			this.avanzaMinuto();
		}
    }

    /**
     * Avanza el Reloj en un minuto.
     * Si al avanzar el Reloj en un minuto pasa de 59, avanza
     * la hora en uno. Y si al avanzar la hora pasa de 11,
     * la regresa a 0.
     */
    public void avanzaMinuto() {
		this.minuto++;
		if (this.minuto >= Reloj.MINUTOS_POR_HORA) {
			this.minuto = 0;
			this.avanzaHora();
		}
    }

    /**
     * Avanza el Reloj en una hora.
     * Si al avanzar la hora pasa de 11, la regresa a 0.
     */
    public void avanzaHora() {
		this.hora++;
		if (this.hora >= Reloj.HORAS_POR_DIA) {
			this.hora = 0;
		}
    }

    /**
     * Retrasa el Reloj un segundo.
     */
    public void retrasaSegundo() {
		this.segundo--;
		if (this.segundo < 0) {
			this.segundo = Reloj.SEGUNDOS_POR_MINUTO - 1;
			this.retrasaMinuto();
		}
    }

    /**
     * Retrasa el Reloj un minuto.
     */
    public void retrasaMinuto() {
		this.minuto--;
		if (this.minuto < 0) {
			this.minuto = Reloj.MINUTOS_POR_HORA - 1;
			this.retrasaHora();
		}
    }

    /**
     * Retrasa el Reloj una hora.
     */
    public void retrasaHora() {
		this.hora--;
		if (this.hora < 0) {
			this.hora = Reloj.HORAS_POR_DIA - 1;
		}
    }
}

/* </ClaseReloj.java> */

/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package icc.primitivos;

/**
 * Imprime la representación binaria de los números.
 * @author blackzafiro
 */
public class ImpresoraBinario {

    /**
     * Imprime los bits de un número entero
     * @param num el número
     */
    public void imprime(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    /**
     * Imprime los bits de un número entero
     * @param num el número
     */
    public void imprime(long num) {
        System.out.println(Long.toBinaryString(num));
    }

    /**
     * Imprime los bits de un número doble
     * @param num el número
     */
    public void imprime(float num) {
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(num)));
    }

    /**
     * Imprime los bits de un número doble
     * @param num el número
     */
    public void imprime(double num) {
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(num)));
    }
}

/* Uso impresora
*
* Implementa la clase ImpresoraBinario para mostrar
* el la representación en binario de todos los valores
* desde 0 hasta 31
*/

package icc.primitivos;

import icc.primitivos.ImpresoraBinario;

public class UsoImpresora {

    // Main method
    public static void main(String[] args) {
        // Crea una instancia de la clase ImpresoraBinario
        ImpresoraBinario impresora = new ImpresoraBinario();

        // Imprime columnas usando el caracter de tabulación
        System.out.println("Int\tBinary");

        // Itera en los enteros desde 0 hasta 31
        for (int i = 0; i < 32; i++) {
            // Imprime el entero y una tabulación sin terminar con nueva línea
            System.out.print(Integer.toString(i) + "\t");

            // Imprime la representación en binario usando "impresora"
            impresora.imprime(i);
        }
    }

}

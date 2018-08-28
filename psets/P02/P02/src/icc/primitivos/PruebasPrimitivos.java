/* Pruebas primitivos */

package icc.primitivos;


public class PruebasPrimitivos {

    public static void main(String[] args) {
        ImpresoraBinario binary_printer = new ImpresoraBinario();

        // Ejercicio 1
        System.out.println("====== Ejercicio 1 ======");
        System.out.println("Representations of 456");

        int uno_i = 456;
        System.out.print("int: " + uno_i + "\t");
        binary_printer.imprime(uno_i);

        long uno_l = 456;
        System.out.print("long: " + uno_l + "\t");
        binary_printer.imprime(uno_l);

        float uno_f = 456;
        System.out.print("float: " + uno_f + "\t");
        binary_printer.imprime(uno_f);

        double uno_d = 456;
        System.out.print("double: " + uno_d + "\t");
        binary_printer.imprime(uno_d);

        // Ejercicio 2
        System.out.println("\n\n====== Ejercicio 2 ======");
        System.out.println("Representations of -456");

        int negative_uno_i = -456;
        System.out.print("int: " + negative_uno_i + "\t");
        binary_printer.imprime(negative_uno_i);

        long negative_uno_l = -456;
        System.out.print("long: " + negative_uno_l + "\t");
        binary_printer.imprime(negative_uno_l);

        float negative_uno_f = -456;
        System.out.print("float: " + negative_uno_f + "\t");
        binary_printer.imprime(negative_uno_f);

        double negative_uno_d = -456;
        System.out.print("double: " + negative_uno_d + "\t");
        binary_printer.imprime(negative_uno_d);
    }

}

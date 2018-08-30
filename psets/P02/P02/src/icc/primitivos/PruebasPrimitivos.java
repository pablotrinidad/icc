/* Pruebas primitivos */

package icc.primitivos;


public class PruebasPrimitivos {

    public static void main(String[] args) {
        ImpresoraBinario binary_printer = new ImpresoraBinario();

        // Ejercicio 1
        System.out.println("====== Ejercicio 1 ======");
        System.out.println("Representations of 456");

        int int_i = 456;
        System.out.print("int: " + int_i + "\t");
        binary_printer.imprime(int_i);

        long int_l = 456;
        System.out.print("long: " + int_l + "\t");
        binary_printer.imprime(int_l);

        float int_f = 456;
        System.out.print("float: " + int_f + "\t");
        binary_printer.imprime(int_f);

        double int_d = 456;
        System.out.print("double: " + int_d + "\t");
        binary_printer.imprime(int_d);

        // Ejercicio 2
        System.out.println("\n\n====== Ejercicio 2 ======");
        System.out.println("Representations of -456");

        int negative_int_i = -456;
        System.out.print("int: " + negative_int_i + "\t");
        binary_printer.imprime(negative_int_i);

        long negative_int_l = -456;
        System.out.print("long: " + negative_int_l + "\t");
        binary_printer.imprime(negative_int_l);

        float negative_int_f = -456;
        System.out.print("float: " + negative_int_f + "\t");
        binary_printer.imprime(negative_int_f);

        double negative_int_d = -456;
        System.out.print("double: " + negative_int_d + "\t");
        binary_printer.imprime(negative_int_d);

        // Ejercicio 3
        System.out.println("\n\n====== Ejercicio 3 ======");
        System.out.println("Representations of -456.601");

        int negative_decimal_i = Math.round(-456.601f);
        System.out.print("int: " + negative_decimal_i + "\t\t");
        binary_printer.imprime(negative_decimal_i);

        long negative_decimal_l = Math.round(-456.601f);
        System.out.print("long: " + negative_decimal_l + "\t\t");
        binary_printer.imprime(negative_decimal_l);

        float negative_decimal_f = -456.601f;
        System.out.print("float: " + negative_decimal_f + "\t\t");
        binary_printer.imprime(negative_decimal_f);

        double negative_decimal_d = -456.601;
        System.out.print("double: " + negative_decimal_d + "\t");
        binary_printer.imprime(negative_decimal_d);

        // Ejercicio 4
        System.out.println("\n\n====== Ejercicio 4 ======");
        int mask = 15;
        System.out.print("int: " + mask + "\t\t");
        binary_printer.imprime(mask);
        int shifted = mask << 3;
        System.out.print("int: " + shifted + "\t");
        binary_printer.imprime(shifted);

        // Ejercicio 5
        System.out.println("\n\n====== Ejercicio 5 ======");
        int n = 1408;
        System.out.print("n: " + n + "\t\t\t");
        binary_printer.imprime(n);
        System.out.print("int: " + mask + "\t\t\t");
        binary_printer.imprime(mask);

        int and_n = n & mask;
        System.out.print("\nn & mask: " + and_n + "\t\t");
        binary_printer.imprime(and_n);

        int or_n = n | mask;
        System.out.print("n | mask: " + or_n + "\t\t");
        binary_printer.imprime(or_n);

        int xor_n = n ^ mask;
        System.out.print("n ^ mask: " + xor_n + "\t\t");
        binary_printer.imprime(xor_n);

        int n_compliment = ~n;
        System.out.print("~n: " + n_compliment + "\t\t");
        binary_printer.imprime(n_compliment);

    }

}

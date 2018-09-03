package icc.p04;

public class Primos {

    public static void main(String[] args) {

        // Verify program is executed correctly.
        if (args.length == 0) {
            System.out.println("\033[31mMissing arguments.\033[0m");
            System.exit(1);
        }

        // Store user input
        int x = Integer.parseInt(args[0]);

        // Evaluate prime properties on the user's input
        boolean xIsPrime = esPrimo(x);

        // Print result
        if (xIsPrime) {
            System.out.println(x + " is prime");
        } else {
            System.out.println(x + " is NOT prime");
        }
    }

    public static boolean esPrimo(int x) {
        // By definition (https://en.wikipedia.org/wiki/Prime_number)
        if (x < 2) {
            return false;
        }

        // Starts iteration at 2 and ends it in x - 1
        for (int i = 2; i < x; i++) {
            // If any common divisor is found, return False
            if (x % i == 0) {
                return false;
            }
        }

        // x is prime
        return true;
    }

}

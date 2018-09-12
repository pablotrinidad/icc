package icc.recursion;

public class Euclides {

    public static void main(String[] args) {
        if (args.length == 2) {
            int r  =  + gcd(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1])
            );
            System.out.println(
                "GCD of " + args[0] + " and " + args[1] + " is " + r
            );
        }
        else {
            // Pair of small numbers
            System.out.println("GCD of " + 64 + " and " + 512 + " is " + gcd(64, 512));

            // Pair of prime numbers
            System.out.println("GCD of " + 29 + " and " + 107 + " is " + gcd(29, 107));

            // Pair of relative prime numbers
            System.out.println("GCD of " + 14 + " and " + 15 + " is " + gcd(14, 15));

            // GCD of x number and 1
            System.out.println("GCD of " + 1 + " and " + 60 + " is " + gcd(1, 60));

            // Pair of large numbers
            System.out.println("GCD of " + 668205 + " and " + 44547 + " is " + gcd(44547, 668205));
        }
    }

    public static int gcd(int x, int y) {
        // x and y should be greater than 0
        if (x == 0 || y == 0) {
            throw new ArithmeticException();
        }

        // gcd found
        if (x == y) {
            return x;
        }
        else {
            return gcd(Math.max(x, y) - Math.min(x, y), Math.min(x, y));
        }

    }

}

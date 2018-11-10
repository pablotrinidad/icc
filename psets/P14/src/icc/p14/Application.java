/**
* Application class
*
* Used to test Matriz2D class features.
* @author pablotrinidad (github.com/pablotrinidad)
*/

package icc.p14;

// Lang libraries
import java.util.Random;


public class Application {

    Random random;

    // Initialize random number generator
    public Application() {
        this.random = new Random();
    }

    // Given a row and cols size, return matrix with random values ranging from 0 to 9
    private Matriz2D genRandomMatrix(int rows, int cols) {
        double data[][] = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j ++)
                data[i][j] = this.random.nextInt(10);
        }
        Matriz2D matrix = Matriz2D.loadFromArray(data);
        return matrix;
    }

    // Test Matriz2D's loadFromArray static method with fixed data
    private void testMatrixConstruction() {
        System.out.println("========================================");
        System.out.println("=  Testing matrix creation from array  =");
        System.out.println("========================================");

        int rows = this.random.nextInt(9) + 2;
        int cols = this.random.nextInt(9) + 2;

        Matriz2D matrix = this.genRandomMatrix(rows, cols);

        System.out.println("Matrix created successfully:");
        System.out.println(matrix + "\n\n");
    }

    // Test matrix addition
    private void testMatrixAddition() {
        System.out.println("=========================================");
        System.out.println("=        Testing matrix addition        =");
        System.out.println("=========================================");

        int rows = this.random.nextInt(5) + 2;
        int cols = this.random.nextInt(5) + 2;

        System.out.println("Creating 2 new " + rows + "x" + cols + " matrices...");
        Matriz2D a = this.genRandomMatrix(rows, cols);
        Matriz2D b = this.genRandomMatrix(rows, cols);

        System.out.println("A:\n" + a);
        System.out.println("B:\n" + b + "\n");

        Matriz2D c = a.add(b);

        System.out.println("Computing sum...");
        System.out.println("C:\n" + c + "\n");
    }

    // Test matrix subtraction
    private void testMatrixSubtraction() {
        System.out.println("========================================");
        System.out.println("=      Testing matrix subtraction      =");
        System.out.println("========================================");

        int rows = this.random.nextInt(5) + 2;
        int cols = this.random.nextInt(5) + 2;

        System.out.println("Creating 2 new " + rows + "x" + cols + " matrices...");
        Matriz2D a = this.genRandomMatrix(rows, cols);
        Matriz2D b = this.genRandomMatrix(rows, cols);

        System.out.println("A:\n" + a);
        System.out.println("B:\n" + b + "\n");

        Matriz2D c = a.subtract(b);

        System.out.println("Computing subtraction...");
        System.out.println("C:\n" + c + "\n");
    }

    // Test matrix multiplication
    private void testMatrixMultiplication() {
        System.out.println("========================================");
        System.out.println("=     Testing matrix multiplication     =");
        System.out.println("========================================");

        int n = this.random.nextInt(4) + 2;
        int m = this.random.nextInt(4) + 2;
        int p = this.random.nextInt(4) + 2;

        System.out.println("Creating 2 new matrices...");
        Matriz2D a = this.genRandomMatrix(n, m);
        Matriz2D b = this.genRandomMatrix(m, p);

        System.out.println("A:\n" + a);
        System.out.println("B:\n" + b + "\n");

        Matriz2D c = a.multiply(b);

        System.out.println("Computing matrix multiplication...");
        System.out.println("C:\n" + c + "\n");
    }

    // Test Matriz2D features.
    public void start() {
        this.testMatrixConstruction();
        this.testMatrixAddition();
        this.testMatrixSubtraction();
        this.testMatrixMultiplication();
    }

    // Main method. Initialize and start app.
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

}

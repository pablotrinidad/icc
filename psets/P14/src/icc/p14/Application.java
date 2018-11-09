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

    // Test Matriz2D's loadFromArray static method with fixed data
    private void testMatrixConstruction() {
        int rows = this.random.nextInt(10) + 1;
        int cols = this.random.nextInt(10) + 1;
        System.out.println("Creating new " + rows + "x" + cols + " matrix:");
        Matriz2D matrix = this.genRandomMatrix(rows, cols);
        System.out.println("Matrix created successfully:");
        System.out.println(matrix + "\n");
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

    // Test Matriz2D features.
    public void start() {
        this.testMatrixConstruction();
    }

    // Main method. Initialize and start app.
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

}

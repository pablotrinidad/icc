/**
* Matriz2D class
*
* Wrapper around a 2D matrix.
* @author pablotrinidad (github.com/pablotrinidad)
*/

package icc.p14;


public class Matriz2D {

    private double data[][];

    // Initialize data attribute as a matrix of the given size.
    public Matriz2D (int rows, int cols) {
        this.data = new double[rows][cols];
    }

    // Given a "2D" array, return a new instance with the given data.
    public static Matriz2D loadFromArray(double[][] input) {
        // Verify array is not empty
        if (input.length == 0) { throw new IllegalArgumentException("Cannot create a 2D matrix from an empty array"); }

        // Store matrix size
        int rows = input.length;
        int columns = input[0].length;

        // Verify array is not empty (columns)
        if (columns == 0) { throw new IllegalArgumentException("Cannot create a 2D matrix from an empty array"); }

        // Initialize new matrix
        Matriz2D matrix = new Matriz2D(rows, columns);

        for(int i = 0; i < rows; i++) {
            double row[] = input[i];

            // Double check row size matches columns count
            if (row.length != columns) {
                throw new IllegalArgumentException("Inconsistent row size found!");
            }

            // Populate matrix data
            for (int j = 0; j < columns; j++) { matrix.data[i][j] = row[j]; }
        }

        return matrix;

    }

    // Return the length of each column (count of rows)
    public int getRows() {
        return this.data.length;
    }

    // Return the length of each row (count of columns)
    public int getColumns() {
        return this.data.length > 0 ? this.data[0].length : 0;
    }

    // Return each element in matrix separated by line break for each rows
    public String toString() {
        String rep = "| ";
        int rows = this.getRows();
        int cols = this.getColumns();
        for(int i = 0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                rep += Double.toString(this.data[i][j]) + " | ";
            }
            rep += "\n| ";
        }
        return rep.substring(0, rep.length() - 3);
    }

    // Handle substraction and addition.
    private Matriz2D addition(Matriz2D b, boolean subtraction) {
        int rows = this.getRows();
        int cols = this.getColumns();

        // Verify if matrices are eligible for the operation
        if (b.getRows() != rows || b.getColumns() != cols) {
            throw new IllegalArgumentException("Matrices must be the same size");
        }

        // Create result matrix
        Matriz2D c = new Matriz2D(rows, cols);

        // Compute operation
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                double x = this.data[i][j];
                double y = subtraction ? (-1) * b.data[i][j] : b.data[i][j];
                c.data[i][j] = x + y;
            }
        }

        return c;
    }

    // Matrix addition
    public Matriz2D add(Matriz2D b) {
        return this.addition(b, false);
    }

    // Matrix subtraction
    public Matriz2D subtract(Matriz2D b) {
        return this.addition(b, true);
    }

    // Matrix multiplication
    public Matriz2D multiply(Matriz2D b) {
        // Verify if matrices are eligible for the operation
        if (b.getRows() != this.getColumns()) {
            throw new IllegalArgumentException("Cannot perform multiplication with this matrices sizes");
        }

        int rows = this.getRows();
        int cols = b.getColumns();
        int m = b.getRows();
        Matriz2D c = new Matriz2D(rows, cols);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int localSum = 0;
                for(int k = 0; k < m; k++) {
                    localSum += this.data[i][k] * b.data[k][j];
                }
                c.data[i][j] = localSum;
            }
        }

        return c;
    }

    // Scalar multiplication
    public Matriz2D multiply(double c) {
        int rows = this.getRows();
        int cols = this.getColumns();
        Matriz2D r = new Matriz2D(rows, cols);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++)
                r.data[i][j] = this.data[i][j] * c;
        }

        return r;
    }

}

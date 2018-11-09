package icc.p14;


public class Matriz2D {

    double data[][];

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
        if (this.data.length > 0) {
            return this.data[0].length;
        } else {
            return 0;
        }
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

}

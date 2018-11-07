public class Matriz2D {

    double data[][];

    // Initialize data attribute as a matrix of the given size.
    public Matriz2D (int rows, int cols) {
        this.data = new double[rows][cols];
    }

    // Given a "1D" array, load it in the matrix by.
    public void loadFromArray(double[] input) {
        int rowsCount = getRows();
        int columnsCount = getColumns();

        // Verify given array contains the right amount of data needed
        if (input.length != (rowsCount * columnsCount)) {
            throw new IllegalArgumentException("Input array does not contain the right amount of data");
        }
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
        String rep = "";
        for(int i = 0; i < this.data.length; i++) {
            for(int j=0; j < this.data.length; j++) {
                rep += Double.toString(this.data[i][j]) + " ";
            }
            rep += "\n";
        }
        return rep;
    }

}

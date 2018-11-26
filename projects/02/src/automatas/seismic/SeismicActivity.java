package automatas.seismic;

import java.util.Map;

public class SeismicActivity {

    // Determine the seismic activity upper bound ('M' in the project description)
    private int threshold;

    // Amount of simulations that the automata will run
    private int t;

    // Grid size (n * n)
    private int n;

    // Cells
    private Cell cells[][];

    public SeismicActivity(int threshold, int t, int n) {
        this.threshold = threshold;
        this.t = t;
        this.n = n;

        // Initialize cells - O(n^2)
        this.cells = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.cells[i][j] = new Cell();
                this.cells[i][j].init(this.t);
            }
        }

        // Load cells' neighbours - O(n^2)
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                int[][] coordinates = {{i, i + 1, i, i - 1}, {j + 1, j, j - 1, j}};
                for (int k = 0; k < 4; k++) {
                    int x = coordinates[0][k];
                    int y = coordinates[1][k];
                    if (x >= 0 && x < this.n && y >= 0 && y < this.n) {
                        cells[i][j].addNeighbour(cells[x][y]);
                    }
                }
            }
        }
    }

    public void start() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j ++) {
                System.out.println(i + ", " + j);
                System.out.println("\tCurrent cell state: " + this.cells[i][j]);
                this.cells[i][j].updateState();
                System.out.println("\tNew cell state: " + this.cells[i][j]);

            }
        }
    }

    public void plot() {
        System.out.println("Plotting");
    }
}

package simulations.seismic;

import simulations.Cell;
import simulations.Simulation;

public class SeismicActivitySimulation extends Simulation {

    // Global attributes
    public final String name = "Seismic Activity Simulation";

    // Simulation-specific attributes
    private int threshold;

    public SeismicActivitySimulation(int n, int t, int threshold) {
        super(n, t);
        this.threshold = threshold;
    }

    public Cell[][] createAutomatas() {
        SeismicAutomata cells[][] = new SeismicAutomata[this.n][this.n];
        for (int i = 0; i < this.n; i ++) {
            for (int j = 0; j < this.n; j++) {
                cells[i][j] = new SeismicAutomata(this.threshold);
            }
        }
        return cells;
    }
}

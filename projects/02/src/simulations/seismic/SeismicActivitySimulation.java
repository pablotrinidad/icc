
package simulations.seismic;

import simulations.Cell;
import simulations.Simulation;

public class SeismicActivitySimulation extends Simulation {

    // Simulation-specific attributes
    private int threshold;

    public SeismicActivitySimulation(int n, int t, int s, int threshold) {
        super(n, t, s);
        this.name = "Seismic Activity Simulation";
        this.threshold = threshold;
    }

    public SeismicAutomata[][] createAutomatas() {
        SeismicAutomata cells[][] = new SeismicAutomata[this.n][this.n];
        for (int i = 0; i < this.n; i ++) {
            for (int j = 0; j < this.n; j++) {
                cells[i][j] = new SeismicAutomata(this.threshold);
            }
        }

        this.updateNeighbors(cells);

        return cells;
    }
}

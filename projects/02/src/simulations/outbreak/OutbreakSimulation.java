package simulations.outbreak;

import simulations.Automata;
import simulations.Simulation;

/*
* Outbreak simulation
*
* Simulate the spread of a "virus" over time.
*
* */
public class OutbreakSimulation extends Simulation {

    // Simulation attributes
    int a;
    int g;

    public OutbreakSimulation(int n, int t, int s, int a, int g) {
        super(n, t, s);
        this.a = a;
        this.g = g;
    }

    @Override
    public Automata[][] createAutomatas() {
        OutbreakAutomata cells[][] = new OutbreakAutomata[this.n][this.n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new OutbreakAutomata(this.a, this.g);
            }
        }

        this.updateNeighbors(cells);
        return cells;
    }
}

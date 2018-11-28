package simulations.wildfire;

import simulations.Automata;
import simulations.Simulation;

/*
* Wildfire simulation
*
* Simulate the evolution of a wildfire over time
*
* */
public class WildfireSimulation extends Simulation {

    // Stochastic variables
    private double p;  // Probability of a new tree growing
    private double f;  // Probability of a new wildfire spontaneously appearing
    private double g;  // Probability of a tree being immune to the fire

    public WildfireSimulation(int n, int t, int  s, double p, double f, double g) {
        super(n, t, s);
        this.name = "Wildfire simulation";
        this.p = p;
        this.f = f;
        this.g = g;
    }

    @Override
    public Automata[][] createAutomatas() {
        WildfireAutomata cells[][] = new WildfireAutomata[n][n];
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.n; j++) {
                cells[i][j] = new WildfireAutomata(this.p, this.f, this.g);
            }
        }

        this.updateNeighbors(cells);
        return cells;
    }

}

package simulations.wildfire;

import javafx.scene.paint.Color;
import simulations.Automata;

/*
* Wildfire simulation
*
* Simulate the spread of a "virus" over time.
*
* */
public class WildfireAutomata extends Automata {

    // Stochastic variables
    double p;  // Probability of a new tree growing
    double f;  // Probability of a new wildfire spontaneously appearing
    double g;  // Probability of a tree being immune to the fire

    public WildfireAutomata(double p, double f, double g) {
        this.p = p;
        this.f = f;
        this.g = g;
        this.state = 0;
        this.updateColor();
    }

    @Override
    public boolean updateState(int t) {
        double event = this.prng.nextDouble();

        // Become tree with a probability of p
        if (this.state == 0) {
            this.state = event < p ? 1 : 0;
        } else if (this.state == 1) {
            // Check for neighbors on fire
            boolean neighborsOnFire = false;
            for (int k = 0; k < 4; k++) {
                if (this.neighbors[k] == null) {
                    break;
                }
                neighborsOnFire = neighborsOnFire || this.neighbors[k].isCritic();
            }

            // If at least one neighbor is on fire, tree gets on fire with (1-g) probability
            if (neighborsOnFire) {
                this.state = event < (1 - g) ? 2 : 1;
            } else {  // Else, gets on fire with (f*(1-g)) probability
                this.state = event < (f * (1 - g)) ? 2 : 1;
            }
        } else {  // If tree is already on fire, becomes dust :(
            this.state = 1;
        }

        this.updateColor();
        return this.isCritic();
    }

    @Override
    public boolean isCritic() {
        return this.state == 2;
    }

    @Override
    public void updateColor() {
        Color color;
        if (this.state == 0) {  // Dirt color
            color = Color.web("#504746");
        } else if (this.state == 1) {  // Green color
            color = Color.web("#7FB800");
        } else {  // Fire color
            color = Color.web("#F6511D");
        }
        this.figure.setFill(color);
    }
}

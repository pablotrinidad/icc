package simulations.outbreak;

import javafx.scene.paint.Color;
import simulations.Automata;

public class OutbreakAutomata extends Automata {

    // Simulation attribures
    int a;
    int g;

    public OutbreakAutomata(int a, int g) {
        this.a = a;
        this.g = g;

        // Initialize state in range of {0,.., a+g}
        this.state = this.prng.nextInt(a + g + 1);
        this.updateColor();
    }

    @Override
    public boolean updateState(int t) {
        if (this.state == 0) {  // Susceptible cell become infectious if at least one neighbor is
            boolean infectiousNeighbors = false;
            for (int k = 0; k < 4; k++) {
                if (this.neighbors[k] == null) {
                    break;
                }
                infectiousNeighbors = infectiousNeighbors || this.neighbors[k].isCritic();
            }

            // Susceptible cell without infectious neighbors stay susceptible
            this.state = infectiousNeighbors ? 1 : 0;
        } else if (this.state == (a + g)) {  // Immune cell become susceptible after g steps
            this.state = 0;
        } else {  // If non of the previous cases match, cell update it's state by 1
            this.state += 1;
        }

        this.updateColor();
        return this.isCritic();
    }

    @Override
    public boolean isCritic() {
        // If cell is between 1 (inclusive) and a (inclusive)
        return this.state > 0 && this.state <= a;
    }

    @Override
    public void updateColor() {
        Color color;
        if (this.state == 0) {  // Susceptible
            color = Color.web("#F3A712");
        } else if (this.state <= this.a) {  // Infected
            color = Color.web("#EE6055");
        } else {  // Immune
            color = Color.web("#23CE6B");
        }
        this.figure.setFill(color);
    }
}

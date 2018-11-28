package simulations.outbreak;

import javafx.scene.paint.Color;
import simulations.Automata;

/*
* Outbreak automata
*
* Follow the evolution rules declared in the project description.
*
* */
public class OutbreakAutomata extends Automata {

    // Simulation attributes
    int a;
    int g;

    public OutbreakAutomata(int a, int g) {
        this.a = a;
        this.g = g;

        // Initialize state in range of {0,.., a+g}
        this.state = this.prng.nextInt(a + g + 1);
        this.updateColor();
    }

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

    public boolean isCritic() {
        // If cell is between 1 (inclusive) and a (inclusive)
        return this.state > 0 && this.state <= a;
    }

    public void updateColor() {
        Color color;
        if (this.state == 0) {  // Susceptible {0}
            color = Color.web("#F3A712");
        } else if (this.state <= this.a) {  // Infected {1, a}
            color = Color.web("#EE6055");
        } else {  // Immune {a+1, g}
            color = Color.web("#23CE6B");
        }
        this.figure.setFill(color);
    }
}

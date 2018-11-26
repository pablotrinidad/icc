package simulations.seismic;

import javafx.scene.paint.Color;
import simulations.Cell;

public class SeismicAutomata extends Cell {

    private int threshold;
    private SeismicAutomata neighbours[] = new SeismicAutomata[4];

    public SeismicAutomata(int threshold) {
        super();
        this.threshold = threshold;
        this.state = this.prng.nextInt(threshold);
        this.updateColor();
    }

    public void updateState() {
        // If cell reached threshold in past t-1, decrease state by 4
        if (this.state == threshold) {
            this.state -= 4;
        } else {
            int increment = 0;
            for(int k = 0; k < 4; k++) {
                SeismicAutomata neighbour = this.neighbours[k];
                if(neighbour == null) {
                    break;
                } else if (neighbour.state == threshold) {
                    increment += 1;
                }
            }
            // If one or more neighbour cells reached threshold in t-1,
            // increase the state by the amount of neighbours in that
            // state, else increment by one.
            this.state += increment > 0 ? increment : 1;

            // If value exceeded threshold because of neighbours,
            // round state back to threshold
            this.state = threshold;
        }
        this.updateColor();
    }

    public void updateState(int t) { this.updateState(); }

    public void updateColor() {
        int red = ((this.state - 1) / (this.threshold - 1)) * 255;
        this.figure.setFill(Color.rgb(this.prng.nextInt(256), 0, 0));
    }
}

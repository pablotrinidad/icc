package simulations.seismic;

import javafx.scene.paint.Color;
import simulations.Cell;

public class SeismicAutomata extends Cell {

    private int threshold;
    private SeismicAutomata neighbours[] = new SeismicAutomata[4];

    public SeismicAutomata(int threshold) {
        super();
        this.threshold = threshold;

        // Initialize cell state with a value between 0 (inclusive) and threshold (exclusive)
        this.state = this.prng.nextInt(threshold);
        this.updateColor();
    }

    public boolean updateState() {
        // If cell reached threshold in past t-1, decrease state by 4
        if (this.state == threshold) {
            this.state -= 4;
        } else {
            int increment = 0;
            // Update neighbors
            for (int k = 0; k < 4; k++) {
                // If cell doesn't have more neighbors
                if(this.neighbours[k] == null) {
                    break;
                }
                increment += this.neighbours[k].isCritic() ? 1 : 0;

            }
            // If neighbors were critic
            this.state += increment > 0 ? increment : 1;

            // Ensures state is not greater than threshold
            this.state = this.state > this.threshold ? this.threshold : this.state;
        }
        this.updateColor();

        // Return true if stated is critic
        return this.state == this.threshold;
    }

    public boolean isCritic() {
        return this.state == this.threshold;
    }


    // Update cell color (heat map)
    private void updateColor() {
        double hue = Color.BLUE.getHue() + (Color.RED.getHue() - Color.BLUE.getHue()) * (this.state) / (this.threshold);
        Color color = Color.hsb(hue, 1.0, 1.0);
        // As the state approaches the threshold, the cell color turn more and more reddish
        this.figure.setFill(color);
    }
}

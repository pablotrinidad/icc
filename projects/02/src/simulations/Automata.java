package simulations;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

public abstract class Automata {

    // UI Elements
    public Rectangle figure;
    private Text text;

    // Automata data
    protected int state;
    protected Automata neighbors[] = new Automata[4];

    // Auxiliaries
    protected Random prng; // Pseudo-random number generator

    public Automata() {
        this.prng = new Random();
        this.text = new Text();
        this.figure = new Rectangle();
        this.figure.setStroke(Color.BLACK);
        this.figure.setFill(null);
    }

    // For simulations that doesn't require to explicitly know the time
    public abstract boolean updateState(int t);

    // Return boolean indicating if state is critic
    public abstract boolean isCritic();

    // Handle cell color depending on the state
    public abstract void updateColor();

    @Override
    public String toString() {
        return Integer.toString(this.state);
    }

}

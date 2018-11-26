package simulations;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/*
* Simulation
*
* Handle basic tasks like starting the simulation
* and calling specific methods to initialize automatas and
* run interface.
*
* */
public abstract class Simulation {

    // Simulation attributes
    private String name;

    // Global attributes
    protected int n;  // Length of square matrix
    protected int t;  // Amount of units of time in which the simulation will run

    // Grid attributes
    private int width = 1000;
    private int height = 1000;
    private Cell[][] cells;

    public Simulation(int n, int t) {
        this.n = n;
        this.t = t;
    }

    // Run simulation and plotting
    public void run(Stage window) {
        this.setupUI(window);

        this.runSimulation();
    }

    // Run simulation t times
    final void runSimulation() {
        for (int localT = 0; localT < this.t; localT ++) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    this.cells[i][j].updateState(localT);  // Send time t
                }
            }
        }
    }

    final void setupUI(Stage window) {
        Pane root = new Pane();

        this.cells = this.createAutomatas();

        double w = this.width / this.n;

        // Add cells to grid
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.cells[i][j].figure = new Rectangle();
                this.cells[i][j].figure.setX(i * w);
                this.cells[i][j].figure.setY(j * w);
                this.cells[i][j].figure.setWidth(w);
                this.cells[i][j].figure.setHeight(w);
                this.cells[i][j].figure.setFill(null);
                this.cells[i][j].figure.setStroke(Color.BLACK);
                root.getChildren().add(this.cells[i][j].figure);
            }
        }

        window.setTitle(this.name);
        Scene scene = new Scene(root, this.width, this.height);
        window.setScene(scene);
        window.show();
    }

    // Implementation is up to each simulation
    public abstract Cell[][] createAutomatas();
}

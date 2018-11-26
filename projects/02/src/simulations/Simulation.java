package simulations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import simulations.seismic.SeismicAutomata;


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
    protected String name;

    // Global attributes
    protected int n;  // Length of square matrix
    protected int t;  // Amount of units of time in which the simulation will run
    protected int s;  // Amount of miliseconds each t-step takes

    // Grid attributes
    private int width = 1000;
    private int height = 1000;
    private Cell[][] cells;

    public Simulation(int n, int t, int s) {
        this.n = n;
        this.t = t;
        this.s = s;
    }

    // Run simulation and plotting
    public void run(Stage window) throws InterruptedException {
        this.setupUI(window);

        this.runSimulation();
    }

    // Run simulation t times
    final void runSimulation() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(this.s),
                (e) -> {
                    for (int i = 0; i < this.n; i++) {
                        for (int j = 0; j < this.n; j++)
                            this.cells[i][j].updateState();  // Send time t
                    }
                }
                ));
        timeline.setCycleCount(this.t);
        timeline.play();
    }

    // Setup UI
    final void setupUI(Stage window) {
        Pane root = new Pane();

        this.cells = this.createAutomatas();

        double w = this.width / this.n;

        // Add cells to grid
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.cells[i][j].figure.setX(i * w);
                this.cells[i][j].figure.setY(j * w);
                this.cells[i][j].figure.setWidth(w);
                this.cells[i][j].figure.setHeight(w);
                root.getChildren().add(this.cells[i][j].figure);
            }
        }

        window.setTitle(this.name);
        Scene scene = new Scene(root, this.width, this.height);
        window.setScene(scene);
        window.show();
    }

    // Add cell neighbors
    protected final void updateNeighbors(Cell[][] cells) {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                int[][] coordinates = {{i, i + 1, i, i - 1}, {j + 1, j, j - 1, j}};
                int index = 0;
                for (int c = 0; c < 4; c++) {
                    int x = coordinates[0][c];
                    int y = coordinates[1][c];
                    if (x >= 0 && x < this.n && y >= 0 && y < this.n) {
                        cells[i][j].neighbors[index] = cells[x][y];
                        index += 1;
                    }
                }
            }
        }
    }

    // Implementation is up to each simulation
    public abstract Cell[][] createAutomatas();
}

package simulations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private Automata[][] cells;

    // Historical data (plot data)
    private int data[][];
    private int currentTime;

    public Simulation(int n, int t, int s) {
        this.n = n;
        this.t = t;
        this.s = s;
        this.data = new int[this.t + 1][2];
        this.currentTime = 0;
    }

    // Run simulation and plotting
    public void run(Stage window) throws InterruptedException {
        this.setupUI(window);

        this.runSimulation();
    }

    // Run simulation t times
    private final void runSimulation() {
        Timeline timeline = new Timeline(new KeyFrame(
            Duration.millis(this.s),
            (e) -> {
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.n; j++)
                        this.updateData(this.cells[i][j].updateState(this.currentTime));
                }
                this.currentTime += 1;
        }));
        timeline.setCycleCount(this.t);
        timeline.play();
        timeline.setOnFinished(e -> this.plotSimulationData());
    }

    // Update simulation data
    private void updateData(boolean critic) {
        if (critic) {
            this.data[this.currentTime][0] += 1;  // First element of each data point is critic count
        } else {
            this.data[this.currentTime][1] += 1; // Second is normal state count
        }
    }

    // Plot simulation data
    private void plotSimulationData() {
        Plot plot = new Plot(this.t + 1, this.n, this.data, this.name);
        plot.display();
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
                this.updateData(this.cells[i][j].isCritic());
            }
        }

        this.currentTime += 1;

        window.setTitle(this.name);
        Scene scene = new Scene(root, this.width, this.height);
        window.setScene(scene);
        window.show();
    }

    // Add cell neighbors
    protected final void updateNeighbors(Automata[][] cells) {
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
    public abstract Automata[][] createAutomatas();
}

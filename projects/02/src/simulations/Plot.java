package simulations;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
* Plot
*
* Receive an array containing the results of running the simulation over
* t time-steps (plus initial state) and launch a new window displaying
* a line chart plot.
*
* */
public class Plot {

    // Plot data
    private int t; // Time the simulation evolved
    private int n; // Number of elements used in simulation
    private int[][] data; // Simulation data
    private String name; // Simulation name

    Plot(int t, int n, int[][] data, String name) {
        this.n = n;
        this.t = t;
        this.data = data;
        this.name = name;
    }

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(this.name + " (Plot)");

        // Initialize axis
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Paso temporal");
        yAxis.setLabel("Estado crítico VS normal (%)");

        // Create chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis, yAxis);
        lineChart.setTitle(this.name);
        lineChart.setCreateSymbols(false);

        // Initialize series
        XYChart.Series criticSerie = new XYChart.Series();
        criticSerie.setName("Células en estado crítico");
        XYChart.Series normalSerie = new XYChart.Series();
        normalSerie.setName("Células en estado normal");

        for (int i = 0; i < this.t; i++) {
             double critic = (double) this.data[i][0] / (this.n * this.n);
             double normal = (double) this.data[i][1] / (this.n * this.n);
             criticSerie.getData().add(new XYChart.Data(i, critic));
             normalSerie.getData().add(new XYChart.Data(i, normal));
        }

        // Add chart
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(criticSerie);
        lineChart.getData().add(normalSerie);


        window.setScene(scene);
        window.show();
    }
}

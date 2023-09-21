package tp1;

import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class ActionGenerer implements Action {

    private Pane graphPane;
    private ChoiceBox<TypeEquation> choixEquation;
    private TextField nombreDonnees;
    private Grapher grapher = new Grapher();
    static int increment = 1;

    public ActionGenerer(Pane graphPane, ChoiceBox<TypeEquation> choixEquation, TextField nombreDonnees) {
        this.graphPane = graphPane;
        this.choixEquation = choixEquation;
        this.nombreDonnees = nombreDonnees;
    }

    @Override
    public void faire() {
        LineChart<Number, Number> lineChart = grapher.creerLineChart(
                new Grapher.Parameters(Integer.parseInt(nombreDonnees.getText()), choixEquation.getValue(), String.valueOf(increment++))
        );
        graphPane.getChildren().add(lineChart);
    }
}
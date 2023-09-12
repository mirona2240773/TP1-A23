package tp1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class ActionGenerer  {

    private Pane graphPane;
    private ChoiceBox<TypeEquation> choixEquation;
    private TextField nombreDonnees;
    private Grapher grapher = new Grapher();
    static int increment = 1;



}
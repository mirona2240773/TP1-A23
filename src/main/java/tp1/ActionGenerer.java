package tp1;

//import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class ActionGenerer implements Action {
    /**
     * crée un Pane
     */
    private Pane graphPane;
    /**
     * crée une ChoiceBox de Type Equation
     */
    private ChoiceBox<TypeEquation> choixEquation;
    /**
     * crée un textfield du nombre de donner
     */
    private TextField nombreDonnees;
    /**
     * crée un Graphe
     */
    private Grapher grapher = new Grapher();
    /**
     * crée une variable pour incrémenter
     */
    static int increment = 1;
    /**
     * Définie le Pane, l'équation et le nombre de point selon l'argument
     * @param graphPane Pane finale de VuePrinciaple
     * @param choixEquation type d'équation choisi
     * @param nombreDonnees nombre de points choisi
     */
    public ActionGenerer(Pane graphPane, ChoiceBox<TypeEquation> choixEquation, TextField nombreDonnees) {
        this.graphPane = graphPane;
        this.choixEquation = choixEquation;
        this.nombreDonnees = nombreDonnees;
    }

    /**
     * Fait le graphe et l'ajoute au Pane finale de VuePrincipale
     */
    @Override
    public void faire() {
        LineChart<Number, Number> lineChart = grapher.creerLineChart(
                new Grapher.Parameters(Integer.parseInt(nombreDonnees.getText()), choixEquation.getValue(), String.valueOf(increment++))
        );
        graphPane.getChildren().add(lineChart);
    }
}
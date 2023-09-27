package tp1;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;




public class Grapher {
    /**
     * Crée une variable finale de la largeur du graphique
     */
    public static final int LARGEUR_GRAPHIQUE = 50;
    /**
     * Crée une variable finale de la hauteur du graphique
     */
    public static final int HAUTEUR_GRAPHIQUE = 50;

    /**
     * Crée une serie de points
     * @param params nombre de points
     */
    public static XYChart.Series<Number, Number> createSeries(Parameters params) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().addAll(getData(params));

        return series;
    }
    /**
     * Crée le graphe selon le nombre de points
     * @param params nombre de points
     */
    public LineChart<Number, Number> creerLineChart(Parameters params) {
        LineChart<Number, Number> lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());
        lineChart.getData().addAll(createSeries(params));
        lineChart.setPrefSize(LARGEUR_GRAPHIQUE,HAUTEUR_GRAPHIQUE);
        return lineChart;
    }
    /**
     * Crée les axes pour le graphe
     */

    private void instancierAxes(NumberAxis xAxis, NumberAxis yAxis, int nombrePoints) { //obsolete
        xAxis.setLabel("x");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(nombrePoints > 0 ? nombrePoints - 1 : nombrePoints);
        xAxis.setTickUnit(1);

        yAxis.setLabel("y");
        yAxis.setMinorTickCount(0);
    }

    private static ArrayList<XYChart.Data<Number, Number>> getData(Parameters params) {
        ArrayList<XYChart.Data<Number, Number>> data = new ArrayList<>();
        Function fx = getFunction(params);
        double result;

        for (int i = 0; i < params.nombrePoints; i++) {
            result = fx.calculate(i);
            if (!Double.isNaN(result))
                data.add(new XYChart.Data<>(i, result));
        }

        return data;
    }
    /**
     * Retourne le type de fonction sélectionner
     * @param params choix de l'utilisateur
     */
    private static Function getFunction(Parameters params) {
        switch (params.typeEquation) {
            case SINUS -> {
                return new Function("f(x)=sin(x)");
            }
            case LINEAR -> {
                return new Function("f(x)=x");
            }
            case QUADRATIC -> {
                return new Function("f(x)=x^2");
            }
            case INVERSE_X -> {
                return new Function("f(x)=1/x");
            }
            default -> throw new RuntimeException("type de fonction invalide");
        }
    }

    /**
     * Crée une Classe qui receuille les donners nécessaire au graphique
     */
    public static class Parameters {
        /**
         * Crée un variable pour le nombre de points
         */
        private int nombrePoints;
        /**
         * Crée un variable pour le typeEquation
         */
        private TypeEquation typeEquation;
        /**
         * Crée un variable pour le nom
         */
        private String name;
        /**
         * Défenie les variables de classes avec les arguments
         * @param nombrePoints nombre de points sélectionner
         * @param typeEquation L'équation sélectionner
         * @param name nom
         */
        public Parameters(int nombrePoints, TypeEquation typeEquation, String name) {
            this.nombrePoints = nombrePoints;
            this.typeEquation = typeEquation;
            this.name = name;
        }

        /**
         * Retourne le nombre de points sélectionner
         * @return nombre de points sélectionner
         */
        public int getNombrePoints() {
            return nombrePoints;
        }
        /**
         * Défénie le nombre de points sélectionner
         */
        public void setNombrePoints(int nombrePoints) {
            this.nombrePoints = nombrePoints;
        }
        /**
         * Retourne l'équation's sélectionner
         * @return l'équation sélectionner
         */
        public TypeEquation getTypeEquation() {
            return typeEquation;
        }
        /**
         * Définie le nombre de points sélectionner
         */
        public void setTypeEquation(TypeEquation typeEquation) {
            this.typeEquation = typeEquation;
        }
        /**
         * Transforme les variables de classes en String lisible
         */
        @Override
        public String toString() {
            return "Parameters{" +
                    "nombrePoints=" + nombrePoints +
                    ", typeEquation=" + typeEquation +
                    ", name='" + name + '\'' +
                    '}';
        }

    }
}

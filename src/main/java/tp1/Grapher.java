package main.java.tp1;

import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;


public class Grapher {

    public XYChart.Series<Number, Number> createGraph(Parameters params) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().addAll(getData(params));

        return series;
    }

    private LineChart<Number, Number> CreerLineChart(Parameters params) {
        //axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        instancierAxes(xAxis, yAxis, params.nombrePoints);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().addAll(getData(params));
        lineChart.getData().add(series);

        return lineChart;
    }

    private void instancierAxes(NumberAxis xAxis, NumberAxis yAxis, int nombrePoints) {
        xAxis.setLabel("x");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(nombrePoints > 0 ? nombrePoints - 1 : nombrePoints);
        xAxis.setTickUnit(1);

        yAxis.setLabel("y");
        yAxis.setMinorTickCount(0);
    }

    private ArrayList<XYChart.Data<Number, Number>> getData(Parameters params) {
        ArrayList<XYChart.Data<Number, Number>> data = new ArrayList<>();
        Function fx = getFunction(params);

        for (int i = 0; i < params.nombrePoints; i++) {
            data.add(new XYChart.Data<>(i, fx.calculate(i)));
        }

        return data;
    }

    private Function getFunction(Parameters params) {
        switch (params.typeEquation) {
            case SINUS -> {
                return new Function("sin(x)");
            }
            case LINEAR -> {
                return new Function("x");
            }
            case QUADRATIC -> {
                return new Function("x^2");
            }
            case INVERSE_X -> {
                return new Function("1/x");
            }
            default -> throw new RuntimeException("type de fonction invalide");
        }
    }


    public static class Parameters {

        private int nombrePoints;
        private TypeEquation typeEquation;
        private String name;

        public Parameters(int nombrePoints, TypeEquation typeEquation, String name) {
            this.nombrePoints = nombrePoints;
            this.typeEquation = typeEquation;
            this.name = name;
        }

        public int getNombrePoints() {
            return nombrePoints;
        }

        public void setNombrePoints(int nombrePoints) {
            this.nombrePoints = nombrePoints;
        }

        public TypeEquation getTypeEquation() {
            return typeEquation;
        }

        public void setTypeEquation(TypeEquation typeEquation) {
            this.typeEquation = typeEquation;
        }

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

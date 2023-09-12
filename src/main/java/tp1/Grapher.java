package tp1;

import javafx.scene.chart.XYChart;
import org.mariuszgromada.math.mxparser.Function;



public class Grapher {

    public XYChart.Series<Number, Number> createGraph(Parameters params) {

        return null;// à changer
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

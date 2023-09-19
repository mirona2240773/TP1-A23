package tp1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class TestImages extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane tp = new TilePane();
        BorderPane bp = new BorderPane(tp);

        tp.getChildren().add(afficherImage("eq1.png"));

        ObservableList<XYChart.Series<X, Y>> list = FXCollections.observableArrayList();
        list.add(Grapher.createSeries(new Grapher.Parameters(5, TypeEquation.SINUS, "wow")));
        LineChart lineChart = new LineChart<>(list);

        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ImageView afficherImage(String nomImage) throws IOException {

        File dossier = new File("./travail/images/" + nomImage);
        dossier.listFiles();

        Image image = new Image(dossier.toURL().openStream());
        ImageView imageView = new ImageView(image);

        return imageView;
    }
}

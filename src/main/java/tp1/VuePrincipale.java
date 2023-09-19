package main.java.tp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Vue pour le Tp1 sur les équations
 *
 * @author Julie.Freve
 * version originale avec les formes
 * @author Martin Simoneau
 * version avec les équations
 */


public class VuePrincipale extends Application {

    private final static Border BORDER = new Border(
            new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null, null));
    public static final int LARGEUR_SCENE = 600;
    public static final int HATEUR_SCENE = 500;
    public static final int TOP_IMAGE_HAUTEUR = 40;
    public static final int TOP_IMAGE_LARGEUR = 100;
    public static final int IMAGE_GAUCHE_TAILLE_SIMPLE = 60;
    public static final int ESPACE_ENTRE_BOUTONS_BAS = 40;
    public static final int ESPACE_VERTICAL_ENTRE_DONNEES_DU_GRAPHIQUE = 10;
    public static final int LARGEUR_MIN_ETIQUETTE_DONNEES = 20;
    public static final int LARGEUR_MIN_TEXTFIELD_DONNEES = 40;
    public static final int EXPACEMENT_ENTRE_X_Y = 10;
    public static final int ESPACE_ENTRE_IMAGE_HAUT = 10;
    public static final double LARGEUR_MIN_SECTION_HAUT = 200.0;

    private Button button1 = new Button("Boutton 1");
    private Button button2 = new Button("Boutton 2");
    private Button button3 = new Button("Boutton 3");

    private Label label = new Label("Nombre de données");

    private TextField textField = new TextField();

    private ChoiceBox choiceBox = new ChoiceBox();

    private Button bouttonAjouterGraphique = new Button("Ajouter un graphique");

    private Button bouttonEffacerlesGraphiques = new Button("Effacer les graphiques");






    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane tilePane = new TilePane(afficherImage("science1.png"));

        GridPane gridPane = new GridPane();
        gridPane.add(afficherImage("science1.png"),0,0);
        gridPane.add(afficherImage("science2.png"),1,0,1,2);
        gridPane.add(afficherImage("science3.png"),0,1);
        gridPane.add(afficherImage("science4.png"),0,2,1,2);
        gridPane.add(afficherImage("science5.png"),1,2);
        gridPane.add(afficherImage("science5.png"),1,3);



//        StackPane stackPane = new StackPane();
//
//        HBox hBox = new HBox(label, textField, choiceBox);
//        HBox hBox1 = new HBox(bouttonAjouterGraphique, bouttonEffacerlesGraphiques);
//        VBox vBox = new VBox(hBox, hBox1);
//
//
//
//        VBox vBox1 = new VBox(tilePane, vBox);
//        AnchorPane anchorPane = new AnchorPane(vBox1);
//        AnchorPane.setTopAnchor(anchorPane,200.0);
//
//        HBox hBox3 = new HBox(afficherImageTravail("eq1.png"));
//        HBox hBox4 = new HBox(button1, button2, button3);
//
//
//        BorderPane borderPane = new BorderPane();;
//        borderPane.setTop(hBox3);
//        borderPane.setLeft(gridPane);
//        borderPane.setRight(anchorPane);
//        borderPane.setBottom(hBox4);


//        afficherImage("science.png");
        Scene scene = new Scene(tilePane,500,400);
        primaryStage.setScene(scene);


        primaryStage.show();

    }

    public ImageView afficherImage(String nomImage) throws IOException {

        File dossier = new File("/ressources.tp1" + nomImage);
        dossier.listFiles();

        Image image = new Image(dossier.toURL().openStream());
        ImageView imageView = new ImageView(image);

        return imageView;
    }

    public ImageView afficherImageTravail(String nomImage) throws IOException {

        File dossier = new File("./travail/images" + nomImage);
        dossier.listFiles();

        Image image = new Image(dossier.toURL().openStream());
        ImageView imageView = new ImageView(image);

        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

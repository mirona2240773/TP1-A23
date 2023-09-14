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

    private TilePane tilePane = new TilePane();




    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(label, textField, choiceBox);
        HBox hBox1 = new HBox(bouttonAjouterGraphique, bouttonEffacerlesGraphiques);
        VBox vBox = new VBox(hBox, hBox1);
        VBox vBox1 = new VBox(tilePane, stackPane, vBox);
        VBox vBox2 = new VBox(gridPane);
        HBox hBox2 = new HBox(vBox2, vBox1);
        HBox hBox3 = new HBox(img...x10)
        HBox hBox4 = new HBox(button1, button2, button3);
        VBox vBox3 = new VBox(hBox3, hBox2, hBox4); // borderPane ici


        afficherImage("science.png");

        Scene scene = new Scene();
        primaryStage.setScene(scene);


        primaryStage.show();

    }

    public ImageView afficherImage(String nomImage) {
        Image image = new Image(this.getClass().getResourceAsStream(nomImage));
        ImageView imageView = new ImageView(image);

        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

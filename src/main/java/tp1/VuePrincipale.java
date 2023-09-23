package tp1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    private ChoiceBox<TypeEquation> choiceBox = new ChoiceBox();

    private Button bouttonAjouterGraphique = new Button("Ajouter un graphique");

    private Button bouttonEffacerlesGraphiques = new Button("Effacer les graphiques");

    private GridPane gridPane = new GridPane();

    private Label auteur = new Label("Alexis miron et Gabriel lebel");

    private TilePane tilePane = new TilePane();


    private HBox hBoxNbDonner = new HBox();

    private HBox hBoxAjouterEffacer = new HBox();

    private HBox hBoxBoutton = new HBox();

    private HBox hBoxFormule = new HBox();

    private AnchorPane anchorPaneOptionGraphique = new AnchorPane();

    private VBox vBoxOptionGraphique = new VBox();

    private VBox vBoxGrid = new VBox();

    private StackPane stackPane = new StackPane();

    private VBox vBoxGrapique = new VBox();

    private BorderPane borderPane = new BorderPane();

//     private static Scene scene = creationScene();


    @Override
    public void start(Stage primaryStage) throws Exception {
        setGridScene();
        sethBoxNbDonner();
        sethBoxAjouterEffacer();
        setvBoxOptionGraphique();
        setTilePane();
        setAnchorPane();
        sethBoxFormule();
        sethBoxBoutton123();
        setStackPane();
        setvBoxGrapique();
        setBorderPane();

        Scene scene = new Scene(borderPane, 1200, HATEUR_SCENE);

        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setMaxWidth(1200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static Scene getScene() throws IOException {
        VuePrincipale vuePrincipale = new VuePrincipale();
        vuePrincipale.creationScene();

        return new Scene(vuePrincipale.borderPane, LARGEUR_SCENE, HATEUR_SCENE);
    }

    private void creationScene() throws IOException {
        setGridScene();
        sethBoxNbDonner();
        sethBoxAjouterEffacer();
        setvBoxOptionGraphique();
        setTilePane();
        setAnchorPane();
        sethBoxFormule();
        sethBoxBoutton123();
        setStackPane();
        setvBoxGrapique();
        setBorderPane();
    }

    private void setBorderPane() {
        borderPane.setTop(hBoxFormule);
        borderPane.setLeft(vBoxGrid);
        borderPane.setCenter(vBoxGrapique);
        borderPane.setBottom(hBoxBoutton);
    }

    private void setvBoxGrapique() {
        vBoxGrapique = new VBox(stackPane, anchorPaneOptionGraphique);
        vBoxGrapique.setPrefSize(300, 375);
        vBoxGrapique.setMinWidth(300);
    }

    private void setStackPane() {
        stackPane = new StackPane(tilePane, auteur);

        auteur.setRotate(90);
        auteur.setTranslateX(70);
        stackPane.setAlignment(auteur, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(stackPane.getChildren().get(1), new Insets(0, 0, 70, 0));

    }

    private void setAnchorPane() throws IOException {
        anchorPaneOptionGraphique = new AnchorPane(vBoxOptionGraphique);
        AnchorPane.setTopAnchor(vBoxOptionGraphique, 10.0);
        AnchorPane.setBottomAnchor(vBoxOptionGraphique, 10.0);
        AnchorPane.setLeftAnchor(vBoxOptionGraphique, 0.0);
        AnchorPane.setRightAnchor(vBoxOptionGraphique, 0.0);
        anchorPaneOptionGraphique.setPrefSize(370, 100);
        anchorPaneOptionGraphique.setStyle("-fx-border-color: blue;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 2;\n");
    }

    private void setvBoxOptionGraphique() throws IOException {
        vBoxOptionGraphique = new VBox(hBoxNbDonner, hBoxAjouterEffacer);
    }

    private void sethBoxFormule() throws IOException {
        for (int i = 1; i <= 10; i++) {
            hBoxFormule.getChildren().add(afficherImageTravail("eq" + String.valueOf(i) + ".png"));
        }
        hBoxFormule.setMinWidth(LARGEUR_MIN_SECTION_HAUT);
        hBoxFormule.setSpacing(ESPACE_ENTRE_IMAGE_HAUT);
    }

    private void sethBoxBoutton123() throws IOException {
        button1.setMinWidth(80);

        button2.setMinWidth(80);
        button2.setMaxWidth(300);

        button3.setMinWidth(80);
        button3.setMaxWidth(3000);
        hBoxBoutton = new HBox(button1, button2, button3);
        hBoxBoutton.setSpacing(ESPACE_ENTRE_BOUTONS_BAS);
        hBoxBoutton.setStyle("-fx-border-color: blue;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 1;\n");
        HBox.setHgrow(hBoxBoutton.getChildren().get(1), Priority.ALWAYS);
        HBox.setHgrow(hBoxBoutton.getChildren().get(2), Priority.SOMETIMES);
    }

    private void sethBoxNbDonner() throws IOException {
        label.setMinWidth(LARGEUR_MIN_ETIQUETTE_DONNEES);

        textField.setMinWidth(LARGEUR_MIN_TEXTFIELD_DONNEES);

        textField.setMaxWidth(40);

        choiceBox.setMinWidth(100);
        choiceBox.getItems().addAll(TypeEquation.LINEAR, TypeEquation.QUADRATIC, TypeEquation.SINUS, TypeEquation.INVERSE_X);

        hBoxNbDonner = new HBox(label, textField, choiceBox);
        hBoxNbDonner.setSpacing(25);
        hBoxNbDonner.setAlignment(Pos.TOP_CENTER);
    }

    private void sethBoxAjouterEffacer() throws IOException {
        bouttonAjouterGraphique.setMinWidth(100);
        bouttonEffacerlesGraphiques.setMinWidth(100);
        hBoxAjouterEffacer = new HBox(bouttonAjouterGraphique, bouttonEffacerlesGraphiques);
        hBoxAjouterEffacer.setPadding(new Insets(10, 25, 10, 25));
        hBoxAjouterEffacer.setSpacing(25);

        hBoxAjouterEffacer.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void setTilePane() throws IOException {
        tilePane.setStyle("-fx-background-color: #" + "FFA500");
        tilePane.setPrefSize(3000, 3700);
        tilePane.setVgap(ESPACE_VERTICAL_ENTRE_DONNEES_DU_GRAPHIQUE);
    }

    private void setGridScene() throws IOException {
        gridPane.add(afficherImage("science1.png"), 0, 0);
        gridPane.add(afficherImage("science2.png"), 1, 0, 1, 2);
        gridPane.add(afficherImage("science3.png"), 0, 1);
        gridPane.add(afficherImage("science4.png"), 0, 2, 1, 2);
        gridPane.add(afficherImage("science5.png"), 1, 2);
        gridPane.add(afficherImage("science5.png"), 1, 3);

        vBoxGrid = new VBox(gridPane);
        vBoxGrid.setAlignment(Pos.CENTER);
        vBoxGrid.setPadding(new Insets(0, 10, 0, 10));

    }

    public ImageView afficherImage(String nomImage) throws IOException {

        Image image = new Image(this.getClass().getResourceAsStream(nomImage));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(IMAGE_GAUCHE_TAILLE_SIMPLE);
        imageView.setFitWidth(IMAGE_GAUCHE_TAILLE_SIMPLE);
        imageView.fitHeightProperty().setValue(60);

        return imageView;
    }

    public ImageView afficherImageTravail(String nomImage) throws IOException {

        File dossier = new File("./travail/images/" + nomImage);
        dossier.listFiles();

        Image image = new Image(dossier.toURL().openStream());
        ImageView imageView = new ImageView(image);


        imageView.setFitHeight(TOP_IMAGE_HAUTEUR);
        imageView.setFitWidth(TOP_IMAGE_LARGEUR);


        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package tp1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    /**
     * Crée le boutton 1
     */
    private Button button1 = new Button("Boutton 1");
    /**
     * Crée le boutton 2
     */
    private Button button2 = new Button("Boutton 2");
    /**
     * Crée le boutton 3
     */
    private Button button3 = new Button("Boutton 3");

    /**
     * Crée le label Nombre de données
     */
    private Label labelNbDonner = new Label("Nombre de données");
    /**
     * Crée le textfield pour la saisie de nombre de points
     */
    private TextField textFieldNbPoints = new TextField();
    /**
     * Crée la boite de choix de graphique
     */
    private ChoiceBox<TypeEquation> choiceBoxGraphique = new ChoiceBox();
    /**
     * Crée le boutton AjouterGrahpique
     */
    private Button bouttonAjouterGraphique = new Button("Ajouter un graphique");

    /**
     * Crée le boutton effacerGraphique
     */
    private Button bouttonEffacerLesGraphiques = new Button("Effacer les graphiques");

    /**
     * Crée le GridPane
     */
    private GridPane gridPane = new GridPane();

    /**
     * Crée le label des noms des auteurs
     */
    private Label auteur = new Label("Alexis miron et Gabriel lebel");

    /**
     * Crée le tilePane
     */
    private TilePane tilePane = new TilePane();

    /**
     * Crée une Hbox Nombre de donner
     */
    private HBox hBoxNbDonner = new HBox();
    /**
     * Crée une Hbox Ajouter Effacer
     */
    private HBox hBoxAjouterEffacer = new HBox();

    /**
     * Crée une Hbox boutton
     */
    private HBox hBoxBoutton = new HBox();

    /**
     * Crée une Hbox Formule
     */
    private HBox hBoxFormule = new HBox();

    /**
     * Crée un AnchorPane OptionGraphique
     */
    private AnchorPane anchorPaneOptionGraphique = new AnchorPane();
    /**
     * Crée une Vbox OptionGraphique
     */
    private VBox vBoxOptionGraphique = new VBox();
    /**
     * Crée une Vbox GridPane
     */
    private VBox vBoxGrid = new VBox();

    /**
     * Crée un StackPane
     */
    private StackPane stackPane = new StackPane();

    /**
     * Crée une Vbox Graphique
     */
    private VBox vBoxGrapique = new VBox();

    /**
     * Crée une BorderPane
     */
    private BorderPane borderPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    /**
     * Crée la scene avec la méthode creationScene et la renvoie
     * @return Scene d'une BorderPane, Sa largeur, Sa hauteur
     */
    public static Scene getScene() throws IOException {
        VuePrincipale vuePrincipale = new VuePrincipale();
        vuePrincipale.creationScene();

        return new Scene(vuePrincipale.borderPane, LARGEUR_SCENE, HATEUR_SCENE);
    }
    /**
     * Crée la scène
     */
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

        associeDialogAuxBoutons(button1, button2, button3);
        associeAjouterGrapgiqueAuxBoutons(bouttonAjouterGraphique);
        associeEffacerGrapgiqueAuxBoutons(bouttonEffacerLesGraphiques);

    }
    /**
     * Crée la BorderPane avec hboxFormule au dessus, vBoxGrid a gauche, vBoxGraphique a droite et hboxBoutton en bas
     */
    private void setBorderPane() {
        borderPane.setTop(hBoxFormule);
        borderPane.setLeft(vBoxGrid);
        borderPane.setCenter(vBoxGrapique);
        borderPane.setBottom(hBoxBoutton);
    }

    /**
     * Crée une Vbox contenant stackPane et AnchorPaneOptionGraphique
     */
    private void setvBoxGrapique() {
        vBoxGrapique = new VBox(stackPane, anchorPaneOptionGraphique);
        vBoxGrapique.setPrefSize(300, 375);
        vBoxGrapique.setMinWidth(300);
    }
    /**
     * Crée la StacPane avec tilePane en dessous et auteur par dessous et dans le coin en bas a gauche
     */

    private void setStackPane() {
        stackPane = new StackPane(tilePane, auteur);

        auteur.setRotate(90);
        auteur.setTranslateX(70);
        stackPane.setAlignment(auteur, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(stackPane.getChildren().get(1), new Insets(0, 0, 70, 0));

    }
    /**
     * Crée la AnchorPane avec vBoxOptionGraphique
     * Définie la couleur de la bordure du AnchorePane
     */
    private void setAnchorPane() throws IOException {
        anchorPaneOptionGraphique = new AnchorPane(vBoxOptionGraphique);
        AnchorPane.setTopAnchor(vBoxOptionGraphique, 10.0);
        AnchorPane.setBottomAnchor(vBoxOptionGraphique, 10.0);
        AnchorPane.setLeftAnchor(vBoxOptionGraphique, 0.0);
        AnchorPane.setRightAnchor(vBoxOptionGraphique, 0.0);
        anchorPaneOptionGraphique.setPrefSize(370, 100);
        anchorPaneOptionGraphique.setBorder(BORDER);
    }
    /**
     * Crée une Vbox contenant la hboxNbDonner et hboxAjouterEffacer
     */
    private void setvBoxOptionGraphique() throws IOException {
        vBoxOptionGraphique = new VBox(hBoxNbDonner, hBoxAjouterEffacer);
    }
    /**
     * Crée une Hbox qui ajoute toute les images contenant des Formules
     */
    private void sethBoxFormule() throws IOException {
        for (int i = 1; i <= 10; i++) {
            hBoxFormule.getChildren().add(afficherImageTravail("eq" + String.valueOf(i) + ".png"));
        }
        hBoxFormule.setMinWidth(LARGEUR_MIN_SECTION_HAUT);
        hBoxFormule.setSpacing(ESPACE_ENTRE_IMAGE_HAUT);
    }
    /**
     * Crée une Hbox contenant les boutton 1,2 et 3
     */
    private void sethBoxBoutton123() throws IOException {
        button1.setMinWidth(80);

        button2.setMinWidth(80);
        button2.setMaxWidth(300);

        button3.setMinWidth(80);
        button3.setMaxWidth(3000);
        hBoxBoutton = new HBox(button1, button2, button3);
        hBoxBoutton.setSpacing(ESPACE_ENTRE_BOUTONS_BAS);
        hBoxBoutton.setBorder(BORDER);
        HBox.setHgrow(hBoxBoutton.getChildren().get(1), Priority.ALWAYS);
        HBox.setHgrow(hBoxBoutton.getChildren().get(2), Priority.SOMETIMES);
    }

    /**
     * Crée une Hbox contenant le labelNbDonner, le textFieldNbPoints et le choiceBox
     * Ajoute les graphiques LINEAR,QUADRATIC,SINUS et INVERSE_X dans la choiceBox
     */
    private void sethBoxNbDonner() throws IOException {
        labelNbDonner.setMinWidth(LARGEUR_MIN_ETIQUETTE_DONNEES);

        textFieldNbPoints.setMinWidth(LARGEUR_MIN_TEXTFIELD_DONNEES);

        textFieldNbPoints.setMaxWidth(40);

        choiceBoxGraphique.setMinWidth(100);
        choiceBoxGraphique.getItems().addAll(TypeEquation.LINEAR, TypeEquation.QUADRATIC, TypeEquation.SINUS, TypeEquation.INVERSE_X);

        hBoxNbDonner = new HBox(labelNbDonner, textFieldNbPoints, choiceBoxGraphique);
        hBoxNbDonner.setSpacing(25);
        hBoxNbDonner.setAlignment(Pos.TOP_CENTER);
    }
    /**
     * Crée une Hbox contenant les boutton AjouterGraphique et EffacerLesGraphiques
     */
    private void sethBoxAjouterEffacer() throws IOException {
        bouttonAjouterGraphique.setMinWidth(100);
        bouttonEffacerLesGraphiques.setMinWidth(100);
        hBoxAjouterEffacer = new HBox(bouttonAjouterGraphique, bouttonEffacerLesGraphiques);
        hBoxAjouterEffacer.setPadding(new Insets(10, 25, 10, 25));
        hBoxAjouterEffacer.setSpacing(25);

        hBoxAjouterEffacer.setAlignment(Pos.BOTTOM_CENTER);
    }

    /**
     * Crée le tilePane qui contiendra les graphiques de bouttonAjouterGraphique
     */
    private void setTilePane() throws IOException {
        tilePane.setStyle("-fx-background-color: #" + "FFA500");
        tilePane.setPrefSize(3000, 3700);
        tilePane.setVgap(ESPACE_VERTICAL_ENTRE_DONNEES_DU_GRAPHIQUE);
//        tilePane.setPrefTileWidth(50);
//        tilePane.setPrefTileHeight(50);
//        tilePane.setTileAlignment(Pos.CENTER);

    }
    /**
     * Crée un GridPane contenant les images sciences obtenue par afficherImage
     */
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
    /**
     * Trouver les images sciences et les renvois avec des grandeurs définis par IMAGE_GAUCHE_TAILLE_SIMPLE
     * @param nomImage
     * @return l'image correspant au path envoyer
     */
    public ImageView afficherImage(String nomImage) throws IOException {

        Image image = new Image(this.getClass().getResourceAsStream(nomImage));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(IMAGE_GAUCHE_TAILLE_SIMPLE);
        imageView.setFitWidth(IMAGE_GAUCHE_TAILLE_SIMPLE);

        return imageView;
    }
    /**
     * Trouver les images eq et les renvois avec des grandeurs définis par TOP_IMAGE_HAUTEUR
     * @param nomImage
     * @return l'image correspond au path
     */
    public ImageView afficherImageTravail(String nomImage) throws IOException {

        File dossier = new File("./travail/images/" + nomImage);
        dossier.listFiles();

        Image image = new Image(dossier.toURL().openStream());
        ImageView imageView = new ImageView(image);


        imageView.setFitHeight(TOP_IMAGE_HAUTEUR);
        imageView.setFitWidth(TOP_IMAGE_LARGEUR);


        return imageView;
    }


    /**
     * Associe lorsque le boutton est cliquer a l'action d'ouvrir le dialogue
     * @param boutons
     */
    private void associeDialogAuxBoutons(Button... boutons) {
        EventHandler<ActionEvent>actionEventEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);

                dialog.setTitle("tp1");
                dialog.setHeaderText("Gabriel Lebel et Alexis miron");
                dialog.setContentText("La fonctionalité n'est pas en service");
                dialog.show();
            }
        };
        for (int i = 0; i < boutons.length; i++) {
            boutons[i].setOnAction(actionEventEventHandler);

        }
    }

    /**
     * Associe lorsque le boutton est cliquer a un évenement qui supprime tout les graphiques
     * @param button
     */
    private void associeEffacerGrapgiqueAuxBoutons(Button button) {

        EventHandler<ActionEvent> actionEventEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tilePane.getChildren().removeAll(tilePane.getChildren());
            }
        };
        button.setOnAction(actionEventEventHandler);
    }
    /**
     * Associe lorsque le boutton est cliquer a un évenement
     * qui Ajoute un graphique selon le nombre de points et type de graphique demandé
     * @param button
     */
    private void associeAjouterGrapgiqueAuxBoutons(Button button) {
        ActionGenerer actionGenerer = new ActionGenerer(tilePane,
                choiceBoxGraphique,textFieldNbPoints);
        EventHandler<ActionEvent> actionEventEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionGenerer.faire();
            }
        };
        button.setOnAction(actionEventEventHandler);
    }

}

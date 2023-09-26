package tp1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.License;

public class ApplicationGraph extends Application {
	public static void main(String[] args) {
		License.iConfirmNonCommercialUse("Martin Simoneau");//ne pas enlever
		launch(args);
	}

	/**
	 *
	 * @param primaryStage the primary stage for this application, onto which
	 * the application scene can be set.
	 * Applications may create other stages, if needed, but they will not be
	 * primary stages.
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(500);
        primaryStage.setMaxWidth(1200);
        primaryStage.setScene(VuePrincipale.getScene());
		primaryStage.show();
	}
}

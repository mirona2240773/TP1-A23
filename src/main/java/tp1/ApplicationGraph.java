package tp1;


import javafx.application.Application;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.License;

public class ApplicationGraph extends Application {

	public static void main(String[] args) {
		License.iConfirmNonCommercialUse("Martin Simoneau");//ne pas enlever
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene();
		primaryStage.show();
	}
}

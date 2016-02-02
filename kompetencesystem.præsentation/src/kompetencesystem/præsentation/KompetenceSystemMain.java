package kompetencesystem.præsentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KompetenceSystemMain extends Application {

	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MockUp.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Kompetence System");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

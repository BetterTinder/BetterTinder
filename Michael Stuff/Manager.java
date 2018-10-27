import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * 
 * @author Michael Fornito
 *
 */
public class Manager extends Application{
	GridPane rootpane = new GridPane();
	Profile profile = new Profile(); //This will be global
	Help help = new Help();//This will be global
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) {
		rootpane.getChildren().add(profile);// This method would be in each button
		Scene scene = new Scene(rootpane,400,500);
		stage.setScene(scene);
		stage.show();
	}
}

//Add the buttons with the action events
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	Button heelp = new Button("Help");	//global help button @Chris
	Setting setting = new Setting(); //this is used in profile; Chris
	Profile profile = new Profile(rootpane,setting); //This will be global
	Help help = new Help();//This will be global
	loginScreen login = new loginScreen();
	NewAccount newAcc = new NewAccount();
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) {
		rootpane.add(heelp, 5,5); //@Chris
		heelp.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
			rootpane.getChildren().add(help);
			}
		});
		rootpane.getChildren().add(profile);// This method would be in each button
		//rootpane.getChildren().add(newAcc); @Chris
		//rootpane.getChildren().add(login);
		Scene scene = new Scene(rootpane,400,500);
		stage.setScene(scene);
		stage.show();
	}
}

//Add the buttons with the action events
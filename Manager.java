import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * 
 * @author Michael Fornito and also Chris did some stuff
 *
 */
public class Manager extends Application{
	GridPane rootpane = new GridPane();
	Button danielleEatsAss = new Button("Help");	//global help button @Chris
	Button danielleSlorpsSpoons=new Button("Profile");
	Setting setting = new Setting(); //this is used in profile; Chris
	Profile profile = new Profile(rootpane,setting); //This will be global
	Help help = new Help();//This will be global
	NewAccount newAcc = new NewAccount(rootpane, profile);
	loginScreen login = new loginScreen(rootpane, newAcc, profile);
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) {
		rootpane.add(danielleEatsAss, 0,500); //@Chris
		danielleEatsAss.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
			rootpane.getChildren().add(help);
			}
		});
		rootpane.add(danielleSlorpsSpoons, 1,500); //@Chris
		danielleSlorpsSpoons.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
			Profile prof=new Profile(rootpane,setting);
			rootpane.getChildren().add(prof);
			}
		});
		rootpane.getChildren().add(login);// This method would be in each button
		Scene scene = new Scene(rootpane,400,500);
		stage.setScene(scene);
		stage.show();
	}
}

//Add the buttons with the action events
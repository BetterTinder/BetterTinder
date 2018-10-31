import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	LoginScreen login = new LoginScreen(rootpane, newAcc, profile);
	//buttons buttons = new buttons();
	HBox hbox = new HBox(10);
	Button helpButton = new Button("Help");
	Button button2 = new Button("My Profile");
	Button button3 = new Button("Find");
	Button button4 = new Button("Matched");	

	//hbox.getChildren().addAll(helpButton, button2, button3, button4);
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) {
		danielleEatsAss.setMinWidth(400);
		danielleSlorpsSpoons.setMinWidth(400);
		danielleEatsAss.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
			rootpane.getChildren().add(help);
			}
		});
		danielleSlorpsSpoons.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
			Setting sett=new Setting();
			Profile prof=new Profile(rootpane,sett);
			rootpane.getChildren().add(prof);
			}
		});
		//profile.setHgap(50);
		//profile.add(buttons,0,500);
		rootpane.getChildren().add(login);// This method would be in each button
		//rootpane.getChildren().add(buttons);
		rootpane.add(danielleEatsAss, 0,496); //@Chris
		rootpane.add(danielleSlorpsSpoons, 0,497); //@Chris
		
		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}
}

//Add the buttons with the action events
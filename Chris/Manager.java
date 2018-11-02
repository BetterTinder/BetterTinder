import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	Setting setting = new Setting(); //this is used in profile; Chris
	Profile profile = new Profile(rootpane,setting); //This will be global
	Help help = new Help();//This will be global
	NewAccount newAcc = new NewAccount(rootpane, profile);
	LoginScreen login = new LoginScreen(rootpane, newAcc, profile);
	//buttons buttons = new buttons()

	//hbox.getChildren().addAll(helpButton, button2, button3, button4);
	
	public static void main(String[] args) {
		launch(args);	
	}
	
	public void start(Stage stage) {
		//profile.setHgap(50);
		//profile.add(buttons,0,500);
		rootpane.getChildren().add(login);// This method would be in each button
		//rootpane.getChildren().add(buttons);
		
		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}
	
public HBox addButtons(GridPane grid1) {
	HBox btnBox = new HBox(10);
	Button helpBtn = new Button("Help");	//global help button @Chris
	Button profBtn=new Button("Profile");
	helpBtn.setMinWidth(85);
	profBtn.setMinWidth(85);
	helpBtn.setOnAction(new EventHandler<ActionEvent>(){ 
		public void handle(ActionEvent event) {
		Help helps = new Help();
		rootpane.getChildren().add(helps);
		}
	});
	profBtn.setOnAction(new EventHandler<ActionEvent>(){ 
		public void handle(ActionEvent event) {
		Setting sett=new Setting();
		Profile prof=new Profile(rootpane,sett);
		rootpane.getChildren().add(prof);
		}
	});
	return btnBox;
}
}
//Add the buttons with the action events
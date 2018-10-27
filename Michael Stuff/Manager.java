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
	Profile profile = new Profile(); //This will be global
	Setting setting = new Setting(); //this is used in profile; Chris
	Help help = new Help();//This will be global
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) {
		rootpane.add(heelp, 0,0);
		rootpane.getChildren().add(profile);// This method would be in each button
		profile.getSettingBtn().setOnAction(new EventHandler<ActionEvent>(){ //@Chris
				public void handle(ActionEvent event) {
				rootpane.getChildren().add(setting);
				}
		});
		heelp.setOnAction(new EventHandler<ActionEvent>(){ //@Chris
			public void handle(ActionEvent event) {
			rootpane.getChildren().add(help);
			}
	});
		Scene scene = new Scene(rootpane,400,500);
		stage.setScene(scene);
		stage.show();
	}
}

//Add the buttons with the action events
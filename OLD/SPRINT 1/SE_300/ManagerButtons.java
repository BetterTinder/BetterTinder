import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * 
 * @author Alec Clawson, Michael Fornito, Chris G, Jacob Do
 *
 */
public class ManagerButtons {
	 Stage mainStage = new Stage();
	
	ManagerButtons(Stage TempStage) {
		mainStage = TempStage; //resets the stage
	}
	

	public Button getMatch() {
		Button MatchedUser = new Button("Matched User");
		// TODO Auto-generated method stub
		return MatchedUser;
	}

	public Button getFind() {
		Button FindUser = new Button("Find User");
		// TODO Auto-generated method stub
		return FindUser;

	}

	public Button getProfile() {
		Button ProfileMain = new Button("Profile");
		ProfileMain.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				manager.startProfile(mainStage);
			}
		});
		// TODO Auto-generated method stub
		return ProfileMain;
	}


	public Button getHelp() {
		Button HelpMain = new Button("Help");
		Help help = new Help();
		HelpMain.setOnAction(new EventHandler<ActionEvent>(){ 
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				manager.startHelp(mainStage);
			}
		});
		return HelpMain;
	}
}






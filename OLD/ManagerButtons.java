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
	
/**
 * 
 * @return button to call Matched class
 */
	public Button getMatch() {
		Button MatchedUser = new Button("Matched User");
		MatchedUser.setMinWidth(85);
		// TODO Auto-generated method stub
		return MatchedUser;
	}
	/**
	 * 
	 * @return button to call find user class
	 */

	public Button getFind() {
		Button FindUser = new Button("Find User");
		FindUser.setMinWidth(85);
		// TODO Auto-generated method stub
		return FindUser;

	}
	/**
	 * 
	 * @return button to call my profile class
	 */

	public Button getProfile() {
		Button ProfileMain = new Button("Profile");
		ProfileMain.setMinWidth(85);
		ProfileMain.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Manager manager = new Manager();
				manager.startProfile(mainStage);
			}
		});
		// TODO Auto-generated method stub
		return ProfileMain;
	}
/**
 * 
 * @return to get call help class
 */
	public Button getHelp() {
		Button HelpMain = new Button("Help");
		HelpMain.setMinWidth(85);
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






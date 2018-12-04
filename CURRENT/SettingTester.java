import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Setting class, where 
 * @author Chris
 *
 */
public class SettingTester extends Application{
	GridPane rootpane = new GridPane();
	String style = "-fx-background-color: rgba(255, 255, 255, 1);";
	UserID userID = new UserID();

	public static void main(String[] args) {
		launch(args);	
	}

	public Profile InitalizeProfile() {
		Profile profile = new Profile(addButtons(rootpane),rootpane); 
		return profile;
	}

	public void start(Stage stage) {
		String tempUserID = "default";
		userID.makeUserID(tempUserID);
		NewAccount newAcc = new NewAccount(addButtons(rootpane), InitalizeProfile());
		SettingScreen setTest = new SettingScreen(rootpane, newAcc, InitalizeProfile());
		rootpane.getChildren().add(setTest);
		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}
	
	public HBox addButtons(GridPane grid1) {
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);

		//Resets the pane every time the method is called by the button
		grid1.getChildren().clear();
		return btnBox;
	}
}
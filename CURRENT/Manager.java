import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/**
 * 
 * @author Chris, Michael, and Danielle
 *
 */
public class Manager extends Application{
	GridPane rootpane = new GridPane();
	String background = "-fx-background-color: #52858F";
	UserID userID = new UserID();
 	
	public static void main(String[] args) {
		launch(args);	
	}
	/**
	 * @param grid1 
	 * @return
	 */
	public Profile InitalizeProfile(GridPane grid1) {
		Profile profile = new Profile(addButtons(grid1),grid1);
		return profile;
	}
 	public void start(Stage stage) {
		String tempUserID = "default";
		userID.makeUserID(tempUserID);
		NewAccount newAcc = new NewAccount(addButtons(rootpane), InitalizeProfile(rootpane));
		LoginScreen login = new LoginScreen(rootpane, newAcc);
		rootpane.getChildren().add(login);
		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param grid1
	 * @return hBox
	 * This method adds the 4 main buttons to the pane which can be grabbed by other panes
	 */
	public HBox addButtons(GridPane grid1) {
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);

		//Resets the pane every time the method is called by the button
		grid1.getChildren().clear();
		grid1.setStyle(background);

		Button helpBtn = getHelpBtn(grid1);

		Button profileBtn = getProfileBtn(grid1);

		Button findBtn = getFindBtn(grid1);

		Button matchedBtn = getMatchedBtn(grid1);

		btnBox.getChildren().addAll(helpBtn,profileBtn,findBtn,matchedBtn);
		btnBox.setTranslateY(380);
		btnBox.setTranslateX(1);
		return btnBox;
	}
	/**
	 * @param grid1
	 * @return
	 */
	private Button getHelpBtn(GridPane grid1) {
		Button helpBtn = new Button("Help");
		grid1.setStyle(background);
		helpBtn.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		helpBtn.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		helpBtn.setMinSize(85, 20);
		helpBtn.setOnAction(event -> {
			System.out.println("Help Button");	
			Help helps = new Help();
			grid1.getChildren().addAll(helps,addButtons(grid1));
		});
		return helpBtn;
	}
	/**
	 * @param grid1
	 * @return
	 */
	private Button getProfileBtn(GridPane grid1) {
		Button profileBtn = new Button("My Profile");
		profileBtn.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		profileBtn.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		profileBtn.setMinSize(85, 20);
		profileBtn.setOnAction(event -> {
			System.out.println("My Profile");
			Profile prof = new Profile(addButtons(grid1), grid1);
			grid1.getChildren().add(prof);

		});
		return profileBtn;
	}
	/**
	 * 
	 * @return
	 */
	private Button getFindBtn(GridPane grid1) {
		Button findBtn = new Button("Find");
		findBtn.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		findBtn.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		findBtn.setMinSize(85, 20);
		findBtn.setOnAction(event -> {
			FindUsers find = new FindUsers(addButtons(grid1),grid1);
			grid1.getChildren().add(find);
			System.out.println("Find");
		});
		return findBtn;
	}
	/**
	 * 
	 * @return
	 */
	private Button getMatchedBtn(GridPane grid1) {
		Button matchedBtn = new Button("Matched");
		matchedBtn.setFont(Font.font("Lucida Bright", FontWeight.LIGHT, 10));
		matchedBtn.setStyle("-fx-background-color: linear-gradient(#767676, #444545);"
				+ "-fx-text-fill: white;");
		matchedBtn.setMinSize(85, 20);
		matchedBtn.setOnAction(event -> {
			System.out.println("Matched");
			ListMatchedUsers matched = ListMatchedUsers.getInstance(addButtons(grid1), rootpane);
			grid1.getChildren().add(matched);
		});
		return matchedBtn;
	}
}
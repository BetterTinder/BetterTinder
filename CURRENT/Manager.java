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
	String style = "-fx-background-color: rgba(255, 255, 255, 1);";
	UserID userID = new UserID();

	public static void main(String[] args) {
		launch(args);	
	}
	/**
	 * 
	 * @return
	 */
	
	public Profile InitalizeProfile() {
		Profile profile = new Profile(addButtons(rootpane),rootpane); 
		return profile;
	}

	public void start(Stage stage) {
		String tempUserID = "default";
		userID.makeUserID(tempUserID);
		NewAccount newAcc = new NewAccount(addButtons(rootpane), InitalizeProfile());
		LoginScreen login = new LoginScreen(rootpane, newAcc, InitalizeProfile());
		rootpane.getChildren().add(login);
		Scene scene = new Scene(rootpane,400,520);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * 
	 * @param grid1
	 * @return hBox
	 * This method adds the 4 main buttons to the pane which can be grabbed by other panes
	 */
	public HBox addButtons(GridPane grid1) {
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);

		//Resets the pane every time the method is called by the button
		grid1.getChildren().clear();
		grid1.setStyle(style);

		Button helpBtn = getHelpBtn(grid1);

		Button profileBtn = getProfileBtn(grid1);

		Button findBtn = getFindBtn(grid1);

		Button matchedBtn = getMatchedBtn();

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
		helpBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		helpBtn.setMinSize(85, 20);
		helpBtn.setOnAction(event -> {
			System.out.println("Help Button");	
			Help helps = new Help();
			grid1.getChildren().addAll(helps,addButtons(grid1));
		});
		return helpBtn;
	}
	/**
	 * 
	 * @param grid1
	 * @return
	 */
	private Button getProfileBtn(GridPane grid1) {
		Button profileBtn = new Button("My Profile");
		profileBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
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
		findBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		findBtn.setMinSize(85, 20);
		findBtn.setOnAction(event -> {
			FindUsers<String> find = new FindUsers<String>(addButtons(grid1),grid1);
			grid1.getChildren().add(find);
			System.out.println("Find");
		});
		return findBtn;
	}
	/**
	 * 
	 * @return
	 */
	private Button getMatchedBtn() {
		Button matchedBtn = new Button("Matched");
		matchedBtn.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
		matchedBtn.setMinSize(85, 20);
		matchedBtn.setOnAction(event -> {
			System.out.println("Matched");
		});
		return matchedBtn;
	}
}
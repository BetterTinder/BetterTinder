import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class loginScreen extends Application {

	
	private Scene loginScene;
	private Button signInButton, newAccountButton, dancerAccount, companyAccount, cancel;
	private TextField usernameField;
	private PasswordField passwordField;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage loginStage) throws Exception {
		
		GridPane loginGridPane = createGridPane();
		
		loginScene = new Scene(loginGridPane);
		addLoginControls(loginGridPane);
		
		loginStage.setScene(loginScene);
		loginStage.setMaxHeight(600);
		loginStage.setMaxWidth(400);
		loginStage.setMinHeight(600);
		loginStage.setMinWidth(400);
		loginStage.setResizable(false);
		loginStage.show();
	}
	
	private GridPane createGridPane() {
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(50);
		gridPane.setHgap(50);
//		gridPane.setGridLinesVisible(true);
		gridPane.setPrefSize(400, 600);
		
//		gridPane.setPrefSize(400, 600);
//		gridPane.setMinSize(400, 600);
//		gridPane.setMaxSize(400, 600);
//		gridPane.setAlignment(Pos.CENTER);
//		gridPane.setPadding(new Insets (100,100,100,100));
//		gridPane.setVgap(50);
//		gridPane.setHgap(50);

		return gridPane;
	}
	
	private void addLoginControls (GridPane gridPane) {
		Label welcomeLabel = new Label("Welcome to RiddleVision");
		welcomeLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		welcomeLabel.setMinSize(200, 100);
		welcomeLabel.setWrapText(true);
		gridPane.add(welcomeLabel,0,0);

		Label usernameLabel = new Label("Username: ");
		usernameLabel.setFont(Font.font("Courier New", FontWeight.LIGHT, 16));
		gridPane.add(usernameLabel,0,1);

		Label passwordLabel = new Label("Password: ");
		passwordLabel.setFont(Font.font("Courier New", FontWeight.LIGHT, 16));
		gridPane.add(passwordLabel, 0,2);

		usernameField = new TextField();
		usernameField.setPromptText("username");
		usernameField.setPrefWidth(400);
		gridPane.add(usernameField, 1,1);

		passwordField = new PasswordField();
		passwordField.setPromptText("password");
		gridPane.add(passwordField, 1, 2);

		signInButton = new Button("Sign In");
		gridPane.add(signInButton, 0, 3);

		newAccountButton = new Button("New Account");
		newAccountButton.setMinSize(Control.USE_PREF_SIZE,Control.USE_PREF_SIZE);
		gridPane.add(newAccountButton, 1, 3);
	}
	
	public void checkLoginInformation() {
		
	}
}

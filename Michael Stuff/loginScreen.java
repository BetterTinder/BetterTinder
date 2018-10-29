import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/**
 *
 * @author danielle and Chris G.
 *
 */
public class loginScreen extends Pane {

	
	public Scene loginScene;
	public Button signInButton, newAccountButton, dancerAccount, companyAccount, cancel;
	public TextField usernameField;
	public PasswordField passwordField;
	
	public static void main(String[] args) {
		System.out.println("Login runnin");
	}
	/**
	 * 
	 * @param grid1
	 * @param newAcc
	 */
	loginScreen (GridPane grid1, NewAccount newAcc) {
		GridPane gridPane = new GridPane();
		String style = "-fx-background-color: rgba(255, 255, 255, 1);";
		gridPane.setStyle(style);
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
		
		//former add control method
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
		newAccountButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				grid1.getChildren().add(newAcc);
			}
		});
		//return
		this.getChildren().add(gridPane);
	}
	
	
	public void checkLoginInformation() {
		
	}
}
